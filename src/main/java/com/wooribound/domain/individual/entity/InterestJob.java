package com.wooribound.domain.individual.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "interest_job")
public class InterestJob {
    @Id
    private Long interestId;
    private String userId;
    private Long jobId;
}
