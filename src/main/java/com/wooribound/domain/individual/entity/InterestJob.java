package com.wooribound.domain.individual.entity;

import com.wooribound.domain.recruitment.entity.Job;
import jakarta.persistence.*;

@Entity
@Table(name = "interest_job")
public class InterestJob {
    @Id
    private Long interestId;
    @Column(name = "user_id")
    private String userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id")
    private Job job;
}
