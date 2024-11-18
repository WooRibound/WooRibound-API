package com.wooribound.api.corporate.controller;


import com.wooribound.api.corporate.dto.ApplicantsDTO;
import com.wooribound.api.corporate.dto.JobPostingReqDTO;
import com.wooribound.api.corporate.facade.EnterpriseJobPostingFacade;
import com.wooribound.domain.jobposting.dto.JobPostingDetailDTO;
import com.wooribound.domain.resume.dto.ResumeDetailDTO;
import com.wooribound.domain.userapply.dto.ApplicantResultReqDTO;
import com.wooribound.global.util.AuthenticateUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("corporate/jobposting")
public class EnterpriseJobPostingController {

    private final EnterpriseJobPostingFacade enterpriseJobPostingFacade;
    private final AuthenticateUtil authenticateUtil;

    // 1. 공고 등록
    @PostMapping(value = "/register", consumes = {"multipart/form-data"})
    public ResponseEntity createJobPosting(Authentication authentication, @ModelAttribute JobPostingReqDTO jobPostingReqDTO) {
        return ResponseEntity.ok().body(enterpriseJobPostingFacade.createJobPosting(authentication, jobPostingReqDTO));
    }

    // 2. 내 기업 공고 목록 조회
    @GetMapping()
    public List<JobPostingDetailDTO> getJobPostingList(Authentication authentication) {
        return enterpriseJobPostingFacade.getJobPostingList(authentication);
    }

    // 3. 공고 조회 - 상세
    @GetMapping("/detail")
    public JobPostingDetailDTO getJobPosting(@RequestParam Long postId) {
        return enterpriseJobPostingFacade.getJobPostingDetail(postId);
    }

    // 4. 공고 지원자 전체 조회
    @GetMapping("/applicant")
    public List<ApplicantsDTO> getJobApplicants(@RequestParam int postId) {
        return enterpriseJobPostingFacade.getJobApplicants(postId);
    }

    // 5. 공고 지원자 이력서 조회
    @GetMapping("/applicant/detail")
    public ResumeDetailDTO getApplicantResume(@RequestParam String userId) {
        return enterpriseJobPostingFacade.getApplicantResume(userId);
    }

    // TODO: 합격여부 설정 시 버튼 컴포넌트 비활성화
    // 6. 지원자 결과 설정
    @PostMapping("/applicant/result")
    public String setApplicantResult(@RequestBody ApplicantResultReqDTO applicantResultReqDTO) {
        return enterpriseJobPostingFacade.setApplicantResult(applicantResultReqDTO);
    }

    // 7. 공고별 지원자 추천 (헤드헌팅기능)
    @GetMapping("/applicant-recommend")
    public List<ApplicantsDTO> getApplicantRecommendation(@RequestParam int jobId) {
        return enterpriseJobPostingFacade.getApplicantRecommendation(jobId);
    }

    
}
