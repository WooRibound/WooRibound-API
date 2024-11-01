package com.wooribound.domain.individual.entity;

import com.wooribound.domain.recruitment.entity.Job;
import jakarta.persistence.*;

@Entity
@Table(name = "work_history")
public class WorkHistory {
    @Id
    private Long exjobId;

    @Column(nullable = false, length = 20)
    private String userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;
}
