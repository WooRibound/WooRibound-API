package com.wooribound.global.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
@Table(name = "user_edu")
@AllArgsConstructor
@Entity
public class UserEdu {
  @Id
  private Long usereduId;
  private String userId;
  private Long eduId;
  private String compState;
  private Date registDate;
}
