package com.wooribound.global.entity;

import com.wooribound.domain.individual.entity.WbUser;
import com.wooribound.global.constant.YN;
import jakarta.persistence.*;

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
  @Column(name = "emp_id")
  private Long empId;

  @Column(name = "ent_id", nullable = false, length = 20)
  private String entId;

  @Enumerated(value = EnumType.STRING)
  @Column(name = "emp_state", nullable = false)
  private YN empState;

  @Enumerated(value = EnumType.STRING)
  @Column(name = "emp_recomm")
  private YN empRecomm;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private WbUser wbUser;
}
