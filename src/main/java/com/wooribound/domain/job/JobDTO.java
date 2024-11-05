package com.wooribound.domain.job;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JobDTO {
    private Long jobId;
    private String jobName;
}
