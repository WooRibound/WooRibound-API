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
public class AdminApproveReqDTO {
    private String entId;
    private YN approve;
}
