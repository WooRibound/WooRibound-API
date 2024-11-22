package com.wooribound.domain.enterprise.dto;

import com.wooribound.global.constant.EntSize;
import jakarta.validation.constraints.NotEmpty;
import java.util.Date;

import jakarta.validation.constraints.Pattern;
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
  @Pattern(
          regexp = "^[0-9]{3}-[0-9]{2}-[0-9]{5}$",
          message = "사업자번호는 ***-**-***** 형식이어야 합니다."
  )
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

  @NotEmpty(message = "entAddr1 필드는 필수입니다.")
  private String entAddr1;

  @NotEmpty(message = "entAddr2 필드는 필수입니다.")
  private String entAddr2;

  @NotEmpty(message = "createdAt 필드는 필수입니다.")
  private Date createdAt;
}
