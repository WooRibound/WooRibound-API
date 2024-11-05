package com.wooribound.api.admin.dto;

import lombok.*;

import java.util.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdminKnowhowDTO {
    private Long knowhowId;
    private String userId;
    private String knowhowJob;
    private String knowhowTitle;
    private String knowhowContent;
}
