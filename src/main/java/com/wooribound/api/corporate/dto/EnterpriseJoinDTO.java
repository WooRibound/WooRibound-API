package com.wooribound.api.corporate.dto;

import com.wooribound.global.constant.EnterpriseSizeType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
@Builder
@Setter
public class EnterpriseJoinDTO {
  @NotBlank(message = "entId 필드는 필수입니다.")
  private String entId;

  @NotBlank(message = "regNum 필드는 필수입니다.")
  private String regNum;

  @NotBlank(message = "entPwd 필드는 필수입니다.")
  private String entPwd;

  @NotBlank(message = "entName 필드는 필수입니다.")
  private String entName;

  @NotBlank(message = "entField 필드는 필수입니다.")
  private String entField;

  @NotNull(message = "enterpriseSizeType 필드는 필수입니다.")
  private EnterpriseSizeType enterpriseSizeType;

  @NotBlank(message = "ceoName 필드는 필수입니다.")
  private String ceoName;

  @NotNull(message = "revenue 필드는 필수입니다.")
  private Long revenue;

  @NotBlank(message = "entAddr1 필드는 필수입니다.")
  private String entAddr1;

  @NotBlank(message = "entAddr2 필드는 필수입니다.")
  private String entAddr2;
}
