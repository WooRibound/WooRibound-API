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
public class AdminEnterpriseDetailDTO {
    private String entId;
    private String ceoName;
    private String entName;
    private String regNum;
    private String entAddr1;
    private String entAddr2;
    private EntSize entSize;
    private String entField;
    private Long revenue;
}
