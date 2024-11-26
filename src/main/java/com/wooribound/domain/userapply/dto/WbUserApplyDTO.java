package com.wooribound.domain.userapply.dto;

import com.wooribound.global.constant.ApplyResult;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class WbUserApplyDTO {
    private Long applyId;
    private ApplyResult result;
    private String entName;
    private String postTitle;
    private Long postId;
    private Date startDate;
    private Date  endDate;
    private String entAddr1;
    private String entAddr2;
}
