package com.wooribound.domain.jobposting.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class JobPostingDTO {
    private Long jobPostingId;
    private String entName;
    private String postTitle;
    private String postImg;
    private Date startDate;
    private Date endDate;
    private String entAddr1;
    private String entAddr2;
    private String postState;
}
