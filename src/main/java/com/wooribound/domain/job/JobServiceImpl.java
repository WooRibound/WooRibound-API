package com.wooribound.domain.job;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;

    @Override
    public List<JobDTO> getAllJobs() {
        List<Job> jobs = jobRepository.findAll();

        return jobs.stream().map(job -> JobDTO.builder()
                        .jobId(job.getJobId())
                        .jobName(job.getJobName())
                        .build())
                .collect(Collectors.toList());
    }
}
