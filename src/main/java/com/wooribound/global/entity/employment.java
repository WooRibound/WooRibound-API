package com.wooribound.global.entity;

import com.wooribound.global.constant.YN;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Builder
@Table(name = "employment")
@AllArgsConstructor
@Entity
public class employment {
  @Id
  private Long empId;
  private String userId;
  private String entId;
  private YN empState;
  private YN empRecomm;
}

