package com.wooribound.global.entity;

import com.wooribound.domain.individual.entity.WbUser;
import com.wooribound.domain.recruitment.entity.JobPosting;
import com.wooribound.global.constant.YN;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
  private String userId;
  private String entId;
  private YN empState;
  private YN empRecomm;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private WbUser wbUser;
}

