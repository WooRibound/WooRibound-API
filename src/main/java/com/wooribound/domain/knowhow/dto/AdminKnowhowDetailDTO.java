package com.wooribound.domain.knowhow.dto;

import lombok.*;

import java.util.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdminKnowhowDetailDTO {
    private Long knowhowId;
    private String userId;
    private String userName;
    private String knowhowJob;
    private String knowhowTitle;
    private String knowhowContent;
    private Date uploadDate;
    private int reportedCnt;
}
