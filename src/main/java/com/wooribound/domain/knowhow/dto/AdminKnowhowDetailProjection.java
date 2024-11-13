package com.wooribound.domain.knowhow.dto;

import java.util.Date;

public interface AdminKnowhowDetailProjection {
    Long getKnowhowId();

    String getKnowhowJob();

    String getUserId();

    String getUserName();

    String getKnowhowTitle();

    String getKnowhowContent();

    Date getUploadDate();

    Long getReportedCnt();
}

