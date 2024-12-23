package com.wooribound.domain.userapply;


import com.wooribound.domain.notification.Notification;
import com.wooribound.domain.wbuser.WbUser;
import com.wooribound.global.constant.ApplyResult;
import com.wooribound.domain.jobposting.JobPosting;
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
import java.util.List;

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
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "apply_id")
  private Long applyId;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "post_id", nullable = false)
  private JobPosting jobPosting;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  private WbUser wbUser;

  @Enumerated(value = EnumType.STRING)
  @Column(name = "result", nullable = false, length = 40 , columnDefinition = "VARCHAR(20) DEFAULT 'PENDING'")
  private ApplyResult result;

  @Column(name = "apply_date", nullable = false)
  private Date applyDate;

  @OneToOne(mappedBy = "userApply", fetch = FetchType.LAZY)
  private Notification notification;

}
