package com.wooribound.domain.individual.entity;


import jakarta.persistence.*;
import com.wooribound.global.entity.Job;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Table(name = "work_history")
public class WorkHistory {
    @Id
    private Long exjobId;

    @Column(name = "user_id", nullable = false, length = 20)
    private String userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;
}
