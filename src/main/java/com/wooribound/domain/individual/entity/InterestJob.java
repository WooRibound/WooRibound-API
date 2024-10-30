package com.wooribound.domain.individual.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class InterestJob {
    @Id
    private Long interestId;
    private String userId;
    private Long jobId;
}
