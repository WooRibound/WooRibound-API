package com.wooribound.global.domain.userapply;


import com.wooribound.domain.individual.entity.WbUser;
import com.wooribound.global.constant.ApplyResult;
import com.wooribound.global.domain.jobposting.JobPosting;
import jakarta.persistence.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@SequenceGenerator(
    name = "user_apply_seq_generator",
    sequenceName = "user_apply_SEQ",
    allocationSize = 1
)
public class UserApply {
  @Id
  @GeneratedValue(
      strategy=GenerationType.AUTO,
      generator = "user_apply_seq_generator"
  )
  @Column(name = "apply_id")
  private Long applyId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "post_id", nullable = false)
  private JobPosting jobPosting;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  private WbUser wbUser;

  @Enumerated(value = EnumType.STRING)
  @Column(name = "result", nullable = false, length = 40 , columnDefinition = "VARCHAR2(20) DEFAULT 'PENDING'")
  private ApplyResult result;

  @Column(name = "apply_date", nullable = false)
  private Date applyDate;
}
