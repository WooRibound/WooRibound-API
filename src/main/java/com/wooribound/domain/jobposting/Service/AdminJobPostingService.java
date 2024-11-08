package com.wooribound.domain.jobposting.Service;

import com.wooribound.api.admin.dto.AdminJobPostingReqDTO;
import com.wooribound.domain.jobposting.dto.JobPostingDTO;
import com.wooribound.domain.jobposting.dto.JobPostingDetailDTO;

import java.util.List;

public interface AdminJobPostingService {
    List<JobPostingDTO> getAllJobPostings(AdminJobPostingReqDTO adminJobPostingReqDTO);

    JobPostingDetailDTO getJobPostingDetail(Long postId);

    String deleteJobPosting(Long postId);
}
