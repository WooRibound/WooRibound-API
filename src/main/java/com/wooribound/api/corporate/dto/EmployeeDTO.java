package com.wooribound.api.corporate.dto;

import com.wooribound.global.constant.YN;
import lombok.*;

import java.util.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class EmployeeDTO {

    private Date hireDate;
    private String userName;
    private String jobName;
    private YN empRecomm;
    private Long empId;
    
}
