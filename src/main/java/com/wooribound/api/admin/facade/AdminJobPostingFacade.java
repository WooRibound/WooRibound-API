package com.wooribound.api.admin.facade;

import com.wooribound.api.admin.dto.AdminJobPostingReqDTO;
import com.wooribound.domain.jobposting.DTO.JobPostingDTO;
import com.wooribound.domain.jobposting.DTO.JobPostingDetailDTO;
import com.wooribound.domain.jobposting.Service.AdminJobPostingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class AdminJobPostingFacade {

    private final AdminJobPostingService adminJobPostingService;

    public List<JobPostingDTO> getJobPostings(AdminJobPostingReqDTO adminJobPostingReqDTO) {
        return adminJobPostingService.getAllJobPostings(adminJobPostingReqDTO);
    }

    public JobPostingDetailDTO getJobPostingDetail(Long postId) {
        return adminJobPostingService.getJobPostingDetail(postId);
    }
}
