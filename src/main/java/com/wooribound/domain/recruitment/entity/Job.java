package com.wooribound.domain.recruitment.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Builder
@Table(name = "job")
@AllArgsConstructor
@Entity
public class Job {
  @Id
  private Long jobId;
  @Column(name = "job_name", nullable = false, length = 20)
  private String jobName;
}

