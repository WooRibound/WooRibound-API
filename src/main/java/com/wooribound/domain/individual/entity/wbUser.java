package com.wooribound.domain.individual.entity;

import com.wooribound.global.constant.Gender;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(name = "wb_user")
@AllArgsConstructor
@Entity
public class wbUser {
  @Id
  private String userId;
  private String providerId;
  private String name;
  private String birth;
  private String phone;
  private Gender gender;
  private String jobEx;
  private String addrCity;
  private String addrProvince;
  private String jobPoint;
  private String jobInterest;
  private String createdAt;
  private String updatedAt;
  private String isDeleted;
}

