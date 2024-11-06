package com.wooribound.domain.enterprise.dto;

import com.wooribound.global.constant.EntSize;
import jakarta.validation.constraints.NotEmpty;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class EnterpriseDTO {
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
  private EntSize entSize;

  @NotEmpty(message = "ceoName 필드는 필수입니다.")
  private String ceoName;

  @NotEmpty(message = "revenue 필드는 필수입니다.")
  private Long revenue;

  @NotEmpty(message = "entAddr 필드는 필수입니다.")
  private String entAddr;

  @NotEmpty(message = "createdAt 필드는 필수입니다.")
  private Date createdAt;
}
