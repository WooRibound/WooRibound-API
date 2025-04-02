package com.wooribound.domain.enterprise.dto;

import com.wooribound.domain.jobposting.JobPosting;
import com.wooribound.domain.notification.Notification;
import com.wooribound.domain.wbuser.WbUser;
import com.wooribound.global.constant.ApplyStatus;
import com.wooribound.global.constant.GenderType;

import java.util.Date;

public interface UserApplyProjection {
    Long getApplyId();
    JobPosting getJobPosting();
    WbUser getWbUser();
    Date getBirth();
    GenderType getGender();
    String getName();
    String getUserId();
    ApplyStatus getResult();
    Notification getNotification();
    int getRecommendCount();
}
