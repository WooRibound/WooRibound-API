package com.wooribound.domain.jobposting.Service;

import com.wooribound.api.admin.dto.AdminJobPostingReqDTO;
import com.wooribound.domain.jobposting.DTO.JobPostingDTO;
import com.wooribound.domain.jobposting.DTO.JobPostingDetailDTO;
import com.wooribound.domain.jobposting.JobPosting;
import com.wooribound.domain.jobposting.JobPostingRepository;
import com.wooribound.domain.knowhow.KnowhowRepository;
import com.wooribound.domain.knowhow.dto.KnowhowDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class AdminJobPostingServiceImpl implements AdminJobPostingService {

    private final JobPostingRepository jobPostingRepository;

    @Override
    public List<JobPostingDTO> getAllJobPostings(AdminJobPostingReqDTO adminJobPostingReqDTO) {
        List<JobPosting> jobPostings = jobPostingRepository.findJobPostings(adminJobPostingReqDTO.getEntName(),
                adminJobPostingReqDTO.getJobName(), adminJobPostingReqDTO.getAddrCity());

        return jobPostings.stream()
                .map(job -> JobPostingDTO.builder()
                        .entName(job.getEnterprise().getEntName())
                        .postTitle(job.getPostTitle())
                        .endDate(job.getEndDate())
                        .postState(job.getPostState())
                        .entAddr(job.getEnterprise().getEntAddr())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public JobPostingDetailDTO getJobPostingDetail(Long postId) {
        JobPosting jobPosting = jobPostingRepository.findJobPostingByPostId(postId);

        return JobPostingDetailDTO.builder()
                .postTitle(jobPosting.getPostTitle())
                .entName(jobPosting.getEnterprise().getEntName())
                .postImg(jobPosting.getPostImg())
                .startDate(jobPosting.getStartDate())
                .endDate(jobPosting.getEndDate())
                .postState(jobPosting.getPostState())
                .jobName(jobPosting.getJob().getJobName())
                .entAddr(jobPosting.getEnterprise().getEntAddr())
                .build();
    }
}
