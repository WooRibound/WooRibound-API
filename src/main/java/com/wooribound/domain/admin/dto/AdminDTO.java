package com.wooribound.domain.admin.dto;

import com.wooribound.global.constant.AdminType;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
@Builder
@Setter
public class AdminDTO {
  @NotEmpty(message = "adminId 필드는 필수입니다.")
  private String adminId;

  @NotEmpty(message = "adminName 필드는 필수입니다.")
  private String adminName;

  @NotEmpty(message = "adminPw 필드는 필수입니다.")
  private String adminPw;

  @NotEmpty(message = "adminType 필드는 필수입니다.")
  private AdminType adminType;
}
