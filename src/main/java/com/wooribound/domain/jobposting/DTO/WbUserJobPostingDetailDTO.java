package com.wooribound.domain.jobposting.DTO;

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
public class WbUserJobPostingDetailDTO {
    private String postTitle;
    private String entName;
    private String postImg;
    private Date startDate;
    private Date endDate;
    private PostState postState;
    private String jobName;
    private String entAddr;
}
