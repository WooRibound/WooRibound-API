package com.wooribound.global.interceptor.service;

import com.wooribound.domain.jobposting.JobPosting;
import com.wooribound.domain.jobposting.JobPostingRepository;
import com.wooribound.global.interceptor.dto.JobPostingLogDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class JobPostingLogService {
    private final JobPostingRepository jobPostingRepository;

    @Transactional(readOnly = true)
    public JobPostingLogDTO getJobPostingLog(Long postId) {
        Optional<JobPosting> byIdJobPosting = jobPostingRepository.findById(postId);
        return byIdJobPosting.map(jobPosting -> JobPostingLogDTO.builder()
                .postTitle(jobPosting.getPostTitle())
                .jobName(jobPosting.getJob().getJobName())
                .entName(jobPosting.getEnterprise().getEntName())
                .entAddr1(jobPosting.getEnterprise().getEntAddr1())
                .build()).orElse(null);
    }
}
