package com.wooribound.domain.individual.entity;


import jakarta.persistence.*;
import com.wooribound.global.domain.job.Job;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Table(name = "work_history")
@SequenceGenerator(
    name = "work_history_seq_generator",
    sequenceName = "work_history_SEQ",
    allocationSize = 1
)
public class WorkHistory {
    @Id
    @GeneratedValue(
        strategy=GenerationType.AUTO,
        generator = "work_history_seq_generator"
    )
    @Column(name = "exjob_id")
    private Long exjobId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private WbUser wbUser;
}
