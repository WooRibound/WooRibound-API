package com.wooribound.global.entity;


import com.wooribound.domain.individual.entity.WbUser;
import com.wooribound.domain.recruitment.entity.JobPosting;
import com.wooribound.global.constant.ApplyResult;
import jakarta.persistence.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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

  @Enumerated(value = EnumType.STRING, columnDefinition = "VARCHAR2(20) DEFAULT 'PENDING'")
  @Column(name = "result", nullable = false, length = 40)
  private ApplyResult result;

  @Column(name = "apply_date", nullable = false)
  private Date applyDate;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  private WbUser wbUser;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "post_id", nullable = false)
  private JobPosting jobPosting;
}
