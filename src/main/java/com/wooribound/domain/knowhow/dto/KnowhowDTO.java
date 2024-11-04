package com.wooribound.domain.knowhow.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class KnowhowDTO {
    private Long knowhowId;
    private String userId;
    private String knowhowJob;
    private String knowhowTitle;
    private String knowhowContent;
    private Date uploadDate;
    private int reportCnt;
}
