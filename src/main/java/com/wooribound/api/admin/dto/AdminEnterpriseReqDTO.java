package com.wooribound.api.admin.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
@Builder
@Setter
public class AdminEnterpriseReqDTO {
    private String entName;
    private String entField;
    private String addrCity;
}
