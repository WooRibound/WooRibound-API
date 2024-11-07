package com.wooribound.api.corporate.dto;

import com.wooribound.global.constant.YN;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class EmploymentReqDTO {
    private Long empId;
    private YN empRecomm;
}
