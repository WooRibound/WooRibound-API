package com.wooribound.global.entity;


import com.wooribound.domain.corporate.entity.Enterprise;
import com.wooribound.domain.individual.entity.WbUser;
import com.wooribound.domain.recruitment.entity.JobPosting;
import com.wooribound.global.constant.ApplyResult;
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
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.util.Lazy;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Builder
@Table(name = "user_apply")
@AllArgsConstructor
@Entity
public class UserApply {
  @Id
  private Long applyId;

  @Column(nullable = false)
  private String entId;

  @Column(nullable = false, columnDefinition = "VARCHAR2(20) DEFAULT 'PENDING'")
  @Enumerated(value = EnumType.STRING)
  private ApplyResult result = ApplyResult.PENDING;

  @Column(nullable = false)
  private Date applyDate;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  private WbUser wbUser;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "post_id", nullable = false)
  private JobPosting jobPosting;
}
