package com.wooribound.global.entity;

import com.wooribound.domain.individual.entity.WbUser;
import com.wooribound.global.constant.YN;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
  private Long empId;

  @Column(nullable = false)
  private String entId;

  @Column(nullable = false)
  @Enumerated(value = EnumType.STRING)
  private YN empState;

  @Enumerated(value = EnumType.STRING)
  private YN empRecomm;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  private WbUser wbUser;
}

