package com.wooribound.api.admin.facade;

import com.wooribound.api.admin.dto.AdminJobPostingReqDTO;
import com.wooribound.domain.jobposting.DTO.JobPostingDTO;
import com.wooribound.domain.jobposting.DTO.JobPostingDetailDTO;
import com.wooribound.domain.jobposting.Service.AdminJobPostingService;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class AdminJobPostingFacade {

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
    public String deleteJobPosting(Long postId) {
        return adminJobPostingService.deleteJobPosting(postId);
    }
}
