package com.wooribound.domain.individual.entity;

import com.wooribound.global.entity.Job;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "interest_job")
public class InterestJob {
    @Id
    private Long interestId;
    @Column(nullable = false)  // NOT NULL 제약 조건
    private String userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id", nullable = false) // NOT NULL 제약 조건
    private Job job;
}
