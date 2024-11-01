package com.wooribound.global.entity;

import jakarta.persistence.Column;
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
  @Column(name = "noti_id")
  private Long notiId;

  @Column(name = "user_id", nullable = false, length = 20)
  private String userId;

  @Column(name = "notice", nullable = false, length = 200)
  private String notice;
}

