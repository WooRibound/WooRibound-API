package com.wooribound.api.admin.facade;

import com.wooribound.api.admin.dto.AdminJobPostingReqDTO;
import com.wooribound.domain.jobposting.dto.JobPostingDTO;
import com.wooribound.domain.jobposting.dto.JobPostingDetailDTO;
import com.wooribound.domain.jobposting.Service.AdminJobPostingService;
import com.wooribound.global.util.AuthenticateUtil;
import org.springframework.security.core.Authentication;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class AdminJobPostingFacade {

    private final AuthenticateUtil authenticateUtil;
    private final AdminJobPostingService adminJobPostingService;

    @Transactional(readOnly = true)
    public List<JobPostingDTO> getJobPostings(AdminJobPostingReqDTO adminJobPostingReqDTO) {
        return adminJobPostingService.getAllJobPostings(adminJobPostingReqDTO);
    }

    @Transactional(readOnly = true)
    public JobPostingDetailDTO getJobPostingDetail(Long postId) {
        return adminJobPostingService.getJobPostingDetail(postId);
    }

    @Transactional
    public String deleteJobPosting(Authentication authentication, Long postId) {
        String userId = authenticateUtil.CheckAdminAuthAndGetUserId(authentication);
        return adminJobPostingService.deleteJobPosting(userId, postId);
    }
}
