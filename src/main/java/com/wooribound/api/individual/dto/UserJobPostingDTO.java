package com.wooribound.api.individual.dto;

import com.wooribound.global.constant.PostState;
import lombok.*;

import java.util.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserJobPostingDTO {
    private String entName;
    private String postTitle;
    private Date endDate;
    private PostState postState;
    private String entAddr;
    private String jobName;
    private String AddrCity;

}
