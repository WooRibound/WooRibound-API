package com.wooribound.api.admin.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdminJobPostingReqDTO {
    private String entName;
    private String jobName;
    private String addrCity;
}
