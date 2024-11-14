package com.wooribound.api.individual.dto;

import lombok.*;

import java.util.Date;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserJobPostingReqDTO {
    private String entName;
    private String postTitle;
    private Date startDate;
    private Date endDate;
    private String jobName;
    private String entAddr1;
    private String entAddr2;
    private List<String> interestJobs;
    private List<String> exJobs;
    private String viewType;
    // TODO: Temp -> Authentication 으로 변경 필요
//    private String userId;
}
