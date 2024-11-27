package com.wooribound.domain.jobposting.dto;

import com.wooribound.global.constant.Gender;

import java.sql.Date;

public interface WbUserProjection {
    String getUserId();
    String getName();
    Character getGender();
    int getRecommendCount();
    Date getBirth();
}
