package com.wooribound.domain.enterprise.dto;

import com.wooribound.global.constant.EnterpriseSizeType;
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
    private EnterpriseSizeType enterpriseSizeType;
    private String entField;
    private Long revenue;
}
