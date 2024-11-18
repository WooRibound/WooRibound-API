package com.wooribound.domain.jobposting.dto;

import java.util.Date;

public interface JobPostingDetailProjection {
    Long getPostId();
    String getPostTitle();
    String getEntName();
    String getPostImg();
    Date getStartDate();
    Date getEndDate();
    String getJobName();
    String getEntAddr1();
    String getEntAddr2();
    int getApplicantCount();
    String getPostState();
}
