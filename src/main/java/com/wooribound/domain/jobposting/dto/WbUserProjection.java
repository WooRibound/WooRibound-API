package com.wooribound.domain.jobposting.dto;

import java.sql.Date;

public interface WbUserProjection {
    String getUserId();
    String getName();
    Character getGender();
    int getRecommendCount();
    Date getBirth();
}
