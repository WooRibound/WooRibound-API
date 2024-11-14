package com.wooribound.api.individual.facade;

import com.wooribound.api.individual.dto.UserApplyDTO;
import com.wooribound.api.individual.dto.UserJobPostingReqDTO;
import com.wooribound.domain.jobposting.Service.WbUserJobPostingService;
import com.wooribound.domain.jobposting.dto.JobPostingDTO;
import com.wooribound.domain.jobposting.dto.JobPostingDetailDTO;
import com.wooribound.domain.userapply.Service.UserApplyService;
import com.wooribound.global.exception.AuthenticationException;
import com.wooribound.global.security.userdetail.admin.AdminUserDetail;
import com.wooribound.global.security.userdetail.enterprise.EnterpriseUserDetail;
import com.wooribound.global.security.userdetail.wbuser.WbUserDetail;
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
    public List<JobPostingDTO> getJobPostings(UserJobPostingReqDTO userJobPostingReqDTO) {
        String loginId = null; // 로그인하지 않은 경우 null로 처리

        return wbUserJobPostingService.getJobPostings(userJobPostingReqDTO);
    }

    // 2-1. 공고 조회 - 새로운 일 구하기
    @Transactional(readOnly = true)
    public List<JobPostingDTO> getJobPostingsForNew(Authentication authentication, UserJobPostingReqDTO userJobPostingReqDTO) {
        String loginId = determineLoginId(authentication);
        return wbUserJobPostingService.getJobPostingsForNew(loginId, userJobPostingReqDTO);
    }

    // 2-2. 공고 조회 - 경력 살리기
    @Transactional(readOnly = true)
    public List<JobPostingDTO> getJobPostingsForCareer(Authentication authentication, UserJobPostingReqDTO userJobPostingReqDTO) {
        String loginId = determineLoginId(authentication);
        return wbUserJobPostingService.getJobPostingsForCareer(loginId, userJobPostingReqDTO);
    }

    // 3. 공고 상세 조회
    @Transactional(readOnly = true)
    public JobPostingDetailDTO getJobPostingDetail(Long postId) {
        return wbUserJobPostingService.getJobPostingDetail(postId);
    }

    // 사용자 유형에 따라 인증 메서드 호출
    private String determineLoginId(Authentication authentication) {
        if (authentication == null) {
            return null;
        }

        Object principal = authentication.getPrincipal();
        if (principal instanceof WbUserDetail) {
            return authenticateUtil.CheckWbUserAuthAndGetUserId(authentication);
        } else if (principal instanceof EnterpriseUserDetail) {
            return authenticateUtil.CheckEnterpriseAuthAndGetUserId(authentication);
        } else if (principal instanceof AdminUserDetail) {
            return authenticateUtil.CheckAdminAuthAndGetUserId(authentication);
        } else {
            throw new AuthenticationException("Invalid user type");
        }
    }


}
