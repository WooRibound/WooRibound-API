package com.wooribound.api.corporate.facade;

import com.wooribound.api.corporate.dto.ApplicantsDTO;
import com.wooribound.api.corporate.dto.JobPostingReqDTO;
import com.wooribound.api.corporate.dto.RecommendationHistoryDTO;
import com.wooribound.domain.jobposting.Service.EntJobPostingService;
import com.wooribound.domain.jobposting.dto.JobPostingDetailDTO;
import com.wooribound.domain.resume.ResumeService;
import com.wooribound.domain.resume.dto.ResumeDetailDTO;
import com.wooribound.domain.userapply.dto.ApplicantResultReqDTO;
import com.wooribound.global.util.AuthenticateUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Component
public class EnterpriseJobPostingFacade {

    private final ResumeService resumeService;
    private final EntJobPostingService entJobPostingService;
    private final AuthenticateUtil authenticateUtil;


    // 1. 공고 등록
    @Transactional
    public String createJobPosting(Authentication authentication, JobPostingReqDTO jobPostingReqDTO) {
        String entId = authenticateUtil.CheckEnterpriseAuthAndGetUserId(authentication);
        return entJobPostingService.createJobPosting(entId, jobPostingReqDTO);
    }

    // 2. 내 기업 공고 목록 조회
    @Transactional(readOnly = true)
    public List<JobPostingDetailDTO> getJobPostingList(Authentication authentication) {
        String entId = authenticateUtil.CheckEnterpriseAuthAndGetUserId(authentication);
        return entJobPostingService.getJobPostingList(entId);
    }

    // 3. 공고 조회 - 상세
    @Transactional(readOnly = true)
    public JobPostingDetailDTO getJobPostingDetail(Long postId) {
        return entJobPostingService.getJobPostingDetail(postId);
    }

    // 3. 공고 지원자 전체 조회
    @Transactional(readOnly = true)
    public List<ApplicantsDTO> getJobApplicants(int postId) {
        return entJobPostingService.getJobApplicants(postId);
    }

    // 4. 공고 지원자 이력서 조회
    @Transactional(readOnly = true)
    public ResumeDetailDTO getApplicantResume(String userId) {
        return resumeService.getWbUserResume(userId);
    }

    // 5. 지원자 결과 설정
    @Transactional
    public String setApplicantResult(ApplicantResultReqDTO applicantResultReqDTO) {
        return entJobPostingService.setApplicantResult(applicantResultReqDTO);
    }

    // 6. 공고별 지원자 추천 (헤드헌팅기능)
    @Transactional(readOnly = true)
    public List<ApplicantsDTO> getApplicantRecommendation(int jobId) {
        return entJobPostingService.getApplicantRecommendation(jobId);
    }

    // 6-1. 기업 추천 내역 조회 (프리미엄 기능)
    public List<RecommendationHistoryDTO> getRecommendationHistory(String userId) {
        return entJobPostingService.getRecommendationHistory(userId);
    }

    // 7. 공고 삭제
    @Transactional
    public String deleteJobPosting(Authentication authentication, Long postId) {
        String userId = authenticateUtil.CheckEnterpriseAuthAndGetUserId(authentication);
        return entJobPostingService.deleteJobPosting(userId, postId);
    }

}
