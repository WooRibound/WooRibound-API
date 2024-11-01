package com.wooribound.global.entity;


import com.wooribound.domain.individual.entity.WbUser;
import com.wooribound.domain.recruitment.entity.JobPosting;
import com.wooribound.global.constant.ApplyResult;
import jakarta.persistence.*;

import java.util.Date;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Builder
@Table(name = "user_apply")
@AllArgsConstructor
@Entity
public class UserApply {
  @Id
  @Column(name = "apply_id")
  private Long applyId;

  @Column(name = "ent_id", nullable = false, length = 20)
  private String entId;

  @Enumerated(value = EnumType.STRING)
  @Column(name = "result", nullable = false, length = 40)
  private ApplyResult result;

  @Column(name = "apply_date", nullable = false)
  private Date applyDate;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private WbUser wbUser;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "post_id")
  private JobPosting jobPosting;
}
