package com.wooribound.api.corporate.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class JobPostingReqDTO {
    private String entId;
    private String postImg;
    private String postTitle;
    private Date startDate;
    private Date endDate;
    // TODO: Figma, 프론트 직무선택 컴포넌트 추가하기 [공고등록 화면]
    private String jobName;




}
