package com.wooribound.api.corporate.dto;

import com.wooribound.global.constant.EntSize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class EnterpriseInfoReqDTO {

    private String entId;
    private String ceoName;
    private String entField;
    private EntSize entSize;
    private String revenue;
    private String entAddr1;
    private String entAddr2;

}
