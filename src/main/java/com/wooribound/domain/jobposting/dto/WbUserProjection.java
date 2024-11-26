package com.wooribound.domain.jobposting.dto;

import com.wooribound.global.constant.Gender;

import java.sql.Date;

public interface WbUserProjection {
    String getUserId();
    String getName();
    Gender getGender();
    Integer getRecommendCount();
    Date getBirth();
}
