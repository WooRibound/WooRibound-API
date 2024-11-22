package com.wooribound.api.individual.controller;

import com.wooribound.api.individual.dto.UserJobPostingReqDTO;
import com.wooribound.api.individual.facade.WbUserJobPostingFacade;
import com.wooribound.domain.jobposting.dto.JobPostingDTO;
import com.wooribound.domain.jobposting.dto.JobPostingDetailDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "개인회원 공고 관련 API", description = "개인 회원 기능 중 공고 관련 기능 입니다.")
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/individualuser/jobposting")
public class WbUserJobPostingController {

    private final WbUserJobPostingFacade wbUserJobPostingFacade;

    @Operation(summary = "공고 지원", description = "공고 지원")
    @PostMapping("/apply")
    public String updateUserApply(Authentication authentication, @RequestParam("postId") Long postId) {
        return wbUserJobPostingFacade.applyForJob(authentication, postId);
    }

    @Operation(summary = "공고 조회 - 검색 (회사명, 직무, 지역)", description = "공고 조회 - 검색 (회사명, 직무, 지역)")
    @PostMapping()
    public List<JobPostingDTO> getJobPostings(@RequestBody(required = false) UserJobPostingReqDTO userJobPostingReqDTO) {

        // RequestBody를 null로 받는 경우 빈 객체 생성
        if (userJobPostingReqDTO != null) {
            log.info("Received UserJobPostingDTO - entName: {}, jobName: {}, entAddr1: {}",
                    userJobPostingReqDTO.getEntName(), userJobPostingReqDTO.getJobName(), userJobPostingReqDTO.getEntAddr1());
        } else {
            log.info("UserJobPostingDTO is null");
        }
        return wbUserJobPostingFacade.getJobPostings(userJobPostingReqDTO);
    }

    @Operation(summary = "공고 조회 - 새로운 일 구하기", description = "공고 조회 - 새로운 일 구하기")
    @PostMapping("/new")
    public List<JobPostingDTO> getJobPostingsForNew(Authentication authentication, @RequestBody UserJobPostingReqDTO userJobPostingReqDTO) {
        // 로그인하지 않은 경우에도 조회 가능하도록 인증 정보가 null인지 확인
        if (authentication == null) {
            log.info("Authentication is null. Processing as guest user.");
        }

        userJobPostingReqDTO.setViewType("new");
        return wbUserJobPostingFacade.getJobPostingsForNew(authentication, userJobPostingReqDTO);
    }

    @Operation(summary = "공고 조회 - 경력 살리기", description = "공고 조회 - 경력 살리기")
    @PostMapping("/career")
    public List<JobPostingDTO> getJobPostingsForCareer(Authentication authentication, @RequestBody UserJobPostingReqDTO userJobPostingReqDTO) {
        // 로그인하지 않은 경우에도 조회 가능하도록 인증 정보가 null인지 확인
        if (authentication == null) {
            log.info("Authentication is null. Processing as guest user.");
        }

        userJobPostingReqDTO.setViewType("career");
        return wbUserJobPostingFacade.getJobPostingsForCareer(authentication, userJobPostingReqDTO);
    }

    @Operation(summary = "공고 상세 조회", description = "공고 상세 조회")
    @GetMapping("/detail")
    public JobPostingDetailDTO getJobPostingDetail(@RequestParam Long postId) {
        return wbUserJobPostingFacade.getJobPostingDetail(postId);
    }

    @Operation(summary = "추천 공고 조회", description = "추천 공고 조회")
    @GetMapping("/recommend")
    public ResponseEntity getJobPostingForRecommend() {
        return ResponseEntity.ok().body(wbUserJobPostingFacade.getJobPostingsForRecommend());
    }
}
