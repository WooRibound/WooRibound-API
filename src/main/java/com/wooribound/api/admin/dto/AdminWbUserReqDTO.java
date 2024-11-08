package com.wooribound.api.admin.dto;

import com.wooribound.global.constant.YN;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
@Builder
@Setter
public class AdminWbUserReqDTO {
    private String userName;
    private String addrCity;
}
