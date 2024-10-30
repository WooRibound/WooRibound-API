package com.wooribound.global.entity;

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
@Table(name = "notification")
@AllArgsConstructor
@Entity
public class Notification {
  @Id
  private Long notiId;
  private String userId;
  private String notice;
}

