package com.wooribound.api.corporate.dto;

import com.wooribound.global.constant.EnterpriseSize;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
@Builder
@Setter
public class EnterpiseJoinDTO {
  @NotEmpty(message = "entId 필드는 필수입니다.")
  private String entId;

  @NotEmpty(message = "regNum 필드는 필수입니다.")
  private String regNum;

  @NotEmpty(message = "entPwd 필드는 필수입니다.")
  private String entPwd;

  @NotEmpty(message = "entName 필드는 필수입니다.")
  private String entName;

  @NotEmpty(message = "entField 필드는 필수입니다.")
  private String entField;

  @NotEmpty(message = "entSize 필드는 필수입니다.")
  private EnterpriseSize enterpriseSize;

  @NotEmpty(message = "ceoName 필드는 필수입니다.")
  private String ceoName;

  @NotEmpty(message = "revenue 필드는 필수입니다.")
  private Long revenue;

  @NotEmpty(message = "entAddr1 필드는 필수입니다.")
  private String entAddr1;

  @NotEmpty(message = "entAddr2 필드는 필수입니다.")
  private String entAddr2;
}
