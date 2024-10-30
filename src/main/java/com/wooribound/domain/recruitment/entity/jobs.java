package com.wooribound.domain.recruitment.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Builder
@Table(name = "jobs")
@AllArgsConstructor
@Entity
public class jobs {
  @Id
  private Long jobId;
  private String jobName;
}

