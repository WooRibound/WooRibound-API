package com.wooribound.domain.jobposting.Service;

import com.wooribound.api.admin.dto.AdminJobPostingReqDTO;
import com.wooribound.domain.jobposting.DTO.JobPostingDTO;
import com.wooribound.domain.jobposting.DTO.JobPostingDetailDTO;
import com.wooribound.domain.jobposting.JobPosting;
import com.wooribound.domain.jobposting.JobPostingRepository;
import com.wooribound.global.exception.NoJobPostingException;
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
                        .jobPostingId(job.getPostId())
                        .entName(job.getEnterprise().getEntName())
                        .postTitle(job.getPostTitle())
                        .endDate(job.getEndDate())
                        .postState(job.getPostState())
                        .entAddr1(job.getEnterprise().getEntAddr1())
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
                .entAddr1(jobPosting.getEnterprise().getEntAddr1())
                .build();
    }

    @Override
    public String deleteJobPosting(Long postId) {
        if (jobPostingRepository.deleteByPostId(postId) != 0) {
            return postId + "번 채용공고를 성공적으로 삭제했습니다.";
        } else {
            throw new NoJobPostingException(postId);
        }
    }
}
