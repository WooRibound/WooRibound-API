package com.wooribound.domain.individual.entity;

import jakarta.persistence.Id;

public class interestJobs {
    @Id
    private Long interestId;
    private String userId;
    private Long jobId;
}
