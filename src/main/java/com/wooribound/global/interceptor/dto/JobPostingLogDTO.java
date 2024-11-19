package com.wooribound.global.interceptor.dto;

import com.wooribound.domain.enterprise.Enterprise;
import com.wooribound.domain.job.Job;
import com.wooribound.domain.jobposting.JobPosting;
import com.wooribound.domain.wbuser.WbUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class JobPostingLogDTO {

    private String postTitle;
    private String jobName;
    private String entName;
    private String entAddr1;

}
