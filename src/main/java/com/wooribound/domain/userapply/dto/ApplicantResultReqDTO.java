package com.wooribound.domain.userapply.dto;

import com.wooribound.global.constant.ApplyResult;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class ApplicantResultReqDTO {

    private Long applyId;
    private ApplyResult applyResult;
}
