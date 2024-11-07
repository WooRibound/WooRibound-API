package com.wooribound.api.individual.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class UserApplyReqDTO {
    private String userId;
    private String applyId;
    private Long postId;
}
