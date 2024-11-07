package com.wooribound.api.admin.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdminKnowhowReqDTO {
    private String knowhowJob;
    private String knowhowTitle;
}
