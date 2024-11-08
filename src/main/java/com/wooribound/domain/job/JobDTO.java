package com.wooribound.domain.job;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class JobDTO {
    private Long jobId;
    private String jobName;
}
