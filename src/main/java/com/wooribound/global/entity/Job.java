package com.wooribound.global.entity;

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
<<<<<<< HEAD:src/main/java/com/wooribound/domain/recruitment/entity/Job.java
  @Column(name = "job_name", nullable = false, length = 20)
=======
  @Column(nullable = false)
>>>>>>> 4e39e755d70f492db6b4cc3100a294b406c68982:src/main/java/com/wooribound/global/entity/Job.java
  private String jobName;
}

