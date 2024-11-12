package com.wooribound.domain.knowhow.dto;

import java.util.Date;

public interface AdminKnowhowDetailProjection {
    Long getKnowhowId();

    String getKnowhowJob();

    String getUserId();

    String getKnowhowTitle();

    String getKnowhowContent();

    Date getUploadDate();

    Long getReportedCnt();
}

