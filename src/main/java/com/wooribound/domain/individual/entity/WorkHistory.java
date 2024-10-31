package com.wooribound.domain.individual.entity;

import com.wooribound.domain.recruitment.entity.Job;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class WorkHistory {
    @Id
    private Long exjobId;
    private String userId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id")
    private Job job;
}
