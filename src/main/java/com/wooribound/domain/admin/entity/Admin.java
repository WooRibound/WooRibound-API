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
  @Column(name = "admin_id", length = 20, nullable = false)
  private String adminId;

  @Column(name = "admin_pw", length = 20, nullable = false)
  private String adminPw;

  @Enumerated(value = EnumType.STRING)
  @Column(name  = "admin_type", nullable = false)
  private AdminType adminType;

}

