package com.wooribound.domain.employment;

import com.wooribound.domain.enterprise.Enterprise;
import com.wooribound.domain.job.Job;
import com.wooribound.domain.wbuser.WbUser;
import com.wooribound.global.constant.YN;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Builder
@Table(name = "employment")
@AllArgsConstructor
@Entity
public class Employment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "emp_id")
  private Long empId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  private WbUser wbUser;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ent_id", nullable = false)
  private Enterprise enterprise;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "job_id", nullable = false)
  private Job job;

  @Enumerated(value = EnumType.STRING)
  @Column(name = "emp_state", nullable = false)
  private YN empState;

  @Enumerated(value = EnumType.STRING)
  @Column(name = "emp_recomm")
  private YN empRecomm;

  @Column(name = "hire_date", nullable = false)
  private LocalDateTime hireDate;

  @PrePersist
  public void prePersist() {
    hireDate = LocalDateTime.now();
  }
}
