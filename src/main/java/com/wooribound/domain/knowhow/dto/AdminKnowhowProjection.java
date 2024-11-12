package com.wooribound.domain.knowhow.dto;

import java.util.Date;

public interface AdminKnowhowProjection {
    Long getKnowhowId();

    String getKnowhowJob();

    String getUserId();

    String getKnowhowTitle();

    Date getUploadDate();

    Long getReportedCnt();
}

