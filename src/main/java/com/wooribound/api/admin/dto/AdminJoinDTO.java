package com.wooribound.api.admin.dto;

import com.wooribound.global.constant.AdminType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
@Builder
@Setter
public class AdminJoinDTO {
  private String adminId;

  private String adminName;

  private String adminPw;

  private AdminType adminType;
}
