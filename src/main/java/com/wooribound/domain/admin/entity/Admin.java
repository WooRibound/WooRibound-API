package com.wooribound.domain.admin.entity;

import com.wooribound.global.constant.AdminType;
import jakarta.persistence.Entity;
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
  private String adminPw;
  private AdminType adminType;
}

