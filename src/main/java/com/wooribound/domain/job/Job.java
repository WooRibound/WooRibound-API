package com.wooribound.domain.job;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Builder
@Table(name = "job")
@AllArgsConstructor
@Entity
@SequenceGenerator(
    name = "job_seq_generator",
    sequenceName = "job_SEQ",
    allocationSize = 1
)
public class Job {
  @Id
  @GeneratedValue(
      strategy=GenerationType.AUTO,
      generator = "job_seq_generator"
  )
  @Column(name = "job_id")
  private Long jobId;

  @Column(name = "job_name", nullable = false, length = 20)
  private String jobName;
}

