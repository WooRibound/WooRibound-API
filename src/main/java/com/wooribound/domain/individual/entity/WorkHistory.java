package com.wooribound.domain.individual.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class WorkHistory {
    @Id
    private Long exjobId;
    private Long jobId;
    private String userId;
}
