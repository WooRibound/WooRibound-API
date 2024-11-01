package com.wooribound.domain.individual.entity;

import com.wooribound.global.domain.job.Job;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "interest_job")
@SequenceGenerator(
    name = "interest_job_seq_generator",
    sequenceName = "interest_job_SEQ",
    allocationSize = 1
)
public class InterestJob {
    @Id
    @GeneratedValue(
        strategy = GenerationType.AUTO,
        generator = "interest_job_seq_generator"
    )
    @Column(name = "interest_id")
    private Long interestId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private WbUser wbUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;
}
