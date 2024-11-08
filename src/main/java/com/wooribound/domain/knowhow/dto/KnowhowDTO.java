package com.wooribound.domain.knowhow.dto;

import lombok.*;

import java.util.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KnowhowDTO {
    private Long knowhowId;
    private String knowhowJob;
    private String knowhowTitle;
    private Date uploadDate;
}
