package com.wooribound.api.individual.dto;

import com.wooribound.global.constant.PostState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class UserJobPostingDTO {
    private String entName;
    private String postTitle;
    private Date endDate;
    private PostState postState;
    private String entAddr;
    private String jobName;
    private String AddrCity;
}
