package com.wooribound.domain.enterprise.dto;

import com.wooribound.domain.jobposting.JobPosting;
import com.wooribound.domain.notification.Notification;
import com.wooribound.domain.wbuser.WbUser;
import com.wooribound.global.constant.ApplyResult;

public interface UserApplyProjection {
    Long getApplyId();
    JobPosting getJobPosting();
    WbUser getWbUser();
    ApplyResult getResult();
    Notification getNotification();
    int getRecommendCount();
}
