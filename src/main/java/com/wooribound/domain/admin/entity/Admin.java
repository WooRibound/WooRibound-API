package com.wooribound.domain.admin.entity;

import com.wooribound.global.constant.AdminType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Builder
@Table(name = "admin")
@AllArgsConstructor
@Entity
public class Admin {
  @Id
  private String adminId;
  @Column(nullable = false)  // NOT NULL 제약 조건
  private String adminPw;
  @Enumerated(value = EnumType.STRING)
  @Column(nullable = false)  // NOT NULL 제약 조건
  private AdminType adminType;
}

