package com.wooribound.domain.job;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job,Long> {

    Job findByJobName(String jobName);
}
