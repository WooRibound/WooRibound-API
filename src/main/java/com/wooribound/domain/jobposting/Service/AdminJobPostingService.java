package com.wooribound.domain.jobposting.Service;

import com.wooribound.api.admin.dto.AdminJobPostingReqDTO;
import com.wooribound.domain.jobposting.DTO.JobPostingDTO;
import com.wooribound.domain.jobposting.DTO.JobPostingDetailDTO;

import java.util.List;

public interface AdminJobPostingService {
    List<JobPostingDTO> getAllJobPostings(AdminJobPostingReqDTO adminJobPostingReqDTO);

    JobPostingDetailDTO getJobPostingDetail(Long postId);
}
