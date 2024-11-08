package com.wooribound.domain.jobposting.Service;

import com.wooribound.api.individual.dto.UserJobPostingDTO;
import com.wooribound.domain.jobposting.JobPosting;
import com.wooribound.domain.jobposting.JobPostingRepository;
import com.wooribound.domain.jobposting.dto.JobPostingDTO;
import com.wooribound.domain.jobposting.dto.JobPostingDetailDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WbUserJobPostingServiceImpl implements WbUserJobPostingService {

    private static final Logger logger = LogManager.getLogger(WbUserJobPostingServiceImpl.class);
    private final JobPostingRepository jobPostingRepository;

    public WbUserJobPostingServiceImpl(JobPostingRepository jobPostingRepository) {
        this.jobPostingRepository = jobPostingRepository;
    }

    // 1. 공고 조회 - 전체, 회사명, 직무, 지역
    @Override
    public List<JobPostingDTO> getJobPostings(UserJobPostingDTO userJobPostingDTO) {
        String entName = userJobPostingDTO.getEntName();
        String jobName = userJobPostingDTO.getJobName();
        String addrCity = userJobPostingDTO.getAddrCity();

        // log4j - 검색 조건 로그 기록
        logger.info("공고 조건 검색 시작 - Company: {}, Job: {}, Location: {}", entName, jobName, addrCity);

        List<JobPosting> jobPostings = jobPostingRepository.findJobPostings(entName, jobName, addrCity);

        // log4j - 검색된 결과 수 & 공고 ID 로그 기록
        logger.info("공고 검색 결과 - Found {} postings", jobPostings.size());
        jobPostings.forEach(job -> logger.info("검색된 공고명 - ID: {}, Title: {}", job.getPostId(), job.getPostTitle()));

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

    // 2. 공고 상세 조회
    @Override
    public JobPostingDetailDTO getJobPostingDetail(Long postId) {
        // log4j - 공고 상세 조회 시작 로그
        logger.info("공고 상세 조회 요청 - ID: {}", postId);

        Optional<JobPosting> jobPostingOptional = jobPostingRepository.findById(postId);
        if (jobPostingOptional.isPresent()) {
            JobPosting jobPosting = jobPostingOptional.get();

            // log4j - 조회된 공고 상세 로그
            logger.info("공고 상세 조회 결과 - ID: {}, Title: {}", jobPosting.getPostId(), jobPosting.getPostTitle());
            return JobPostingDetailDTO.builder()
                                .postTitle(jobPosting.getPostTitle())
                                .entName(jobPosting.getEnterprise().getEntName())
                                .postImg(jobPosting.getPostImg())
                                .startDate(jobPosting.getStartDate())
                                .endDate(jobPosting.getEndDate())
                                .postState(jobPosting.getPostState())
                                .jobName(jobPosting.getJob().getJobName())
                                .entAddr1(jobPosting.getEnterprise().getEntAddr1())
                                .entAddr2(jobPosting.getEnterprise().getEntAddr2())
                                .build();
        } else {
            // 공고가 존재하지 않는 경우 예외 로그
            logger.error("공고가 존재하지 않습니다 - ID: {}", postId);
            // 공고가 존재하지 않는 경우 예외 처리
            throw new RuntimeException("해당 공고 없음: " + postId);
        }
    }



}