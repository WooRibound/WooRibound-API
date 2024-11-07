package com.wooribound.api.corporate.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class EntUserApplyReqDTO {
    private String entId;
    private String userId;
    private String applyId;
    private Long postId;
}
