package com.wooribound.domain.enterprise.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class AdminEnterpriseDTO {
    private String entId;
    private String entName;
    private String entField;
    private String addrCity;
}
