package com.wooribound.api.admin.dto;

import lombok.*;

import java.util.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdminKnowhowDTO {
    private String knowhowJob;
    private String knowhowTitle;
}
