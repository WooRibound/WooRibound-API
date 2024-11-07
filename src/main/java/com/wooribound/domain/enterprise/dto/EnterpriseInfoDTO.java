package com.wooribound.domain.enterprise.dto;

import com.wooribound.global.constant.EntSize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class EnterpriseInfoDTO {

    private String entId;
    private String regNum;
    private String entName;
    private String ceoName;
    private String entField;
    private EntSize entSize;
    private Long revenue;
    private String entAddr1;
    private String entAddr2;
}
