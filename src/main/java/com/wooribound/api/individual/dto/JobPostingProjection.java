package com.wooribound.api.individual.dto;

import com.wooribound.domain.enterprise.Enterprise;
import com.wooribound.domain.jobposting.dto.JobPostingDetailProjection;

import java.util.Date;

public interface JobPostingProjection {
    Long getPostId();
    String getEntName();
    String getPostTitle();
    String getPostImg();
    Date getStartDate();
    Date getEndDate();
    String getJobName();
    String getPostState();
    Enterprise getEnterprise();
}