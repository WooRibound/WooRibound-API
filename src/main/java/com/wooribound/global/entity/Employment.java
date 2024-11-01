package com.wooribound.global.entity;

import com.wooribound.domain.individual.entity.WbUser;
import com.wooribound.domain.recruitment.entity.JobPosting;
import com.wooribound.global.constant.YN;
import jakarta.persistence.*;

import java.util.List;
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
  @Column(name = "ent_id")
  private String entId;
  @Enumerated(value = EnumType.STRING)
  private YN empState;
  @Enumerated(value = EnumType.STRING)
  private YN empRecomm;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private WbUser wbUser;
}

