package com.wooribound.api.individual.facade;

import com.wooribound.api.individual.dto.UserApplyDTO;
import com.wooribound.api.individual.dto.UserJobPostingReqDTO;
import com.wooribound.domain.jobposting.Service.WbUserJobPostingService;
import com.wooribound.domain.jobposting.dto.JobPostingDTO;
import com.wooribound.domain.jobposting.dto.JobPostingDetailDTO;
import com.wooribound.domain.userapply.Service.UserApplyService;
import com.wooribound.global.util.AuthenticateUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
public class WbUserJobPostingFacade {

    private final UserApplyService userApplyService;
    private final WbUserJobPostingService wbUserJobPostingService;
    private final AuthenticateUtil authenticateUtil;

    // 1. 공고 지원
    @Transactional
    public String applyForJob(UserApplyDTO userApplyDTO) {
        return userApplyService.createUserApply(userApplyDTO);
    }


    // 2. 공고 조회 - 검색
    @Transactional(readOnly = true)
    public List<JobPostingDTO> getJobPostings(Authentication authentication, UserJobPostingReqDTO userJobPostingReqDTO) {
        String loginId = authenticateUtil.CheckWbUserAuthAndGetUserId(authentication);
        return wbUserJobPostingService.getJobPostings(loginId, userJobPostingReqDTO);
    }

    // 2-1. 공고 조회 - 새로운 일 구하기
    @Transactional(readOnly = true)
    public List<JobPostingDTO> getJobPostingsForNew(Authentication authentication, UserJobPostingReqDTO userJobPostingReqDTO) {
        String loginId = authenticateUtil.CheckWbUserAuthAndGetUserId(authentication);
        return wbUserJobPostingService.getJobPostingsForNew(loginId, userJobPostingReqDTO);
    }
    // 2-2. 공고 조회 - 경력 살리기
    @Transactional(readOnly = true)
    public List<JobPostingDTO> getJobPostingsForCareer(Authentication authentication, UserJobPostingReqDTO userJobPostingReqDTO) {
        String loginId = authenticateUtil.CheckWbUserAuthAndGetUserId(authentication);
        return wbUserJobPostingService.getJobPostingsForCareer(loginId, userJobPostingReqDTO);
    }

    // 3. 공고 상세 조회
    @Transactional(readOnly = true)
    public JobPostingDetailDTO getJobPostingDetail(Long postId) {
        return wbUserJobPostingService.getJobPostingDetail(postId);
    }

}
