package com.wooribound.domain.individual.entity;

import com.wooribound.domain.recruitment.entity.Job;
import jakarta.persistence.*;

@Entity
public class WorkHistory {
    @Id
    private Long exjobId;
    @Column(name = "user_id")
    private String userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id")
    private Job job;
}
