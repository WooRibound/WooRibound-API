package com.wooribound.domain.jobposting.dto;

import com.wooribound.global.constant.Gender;

import java.sql.Date;

public interface WbUserProjection {
    String getUserId();
    String getName();
    Gender getGender();
    int getRecommendCount();
    Date getBirth();
}
