package com.wooribound.api.individual.dto;

import com.wooribound.global.constant.GenderType;
import com.wooribound.global.constant.YN;

import lombok.*;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class WbUserDTO {
    private String userId;
    private String name;
    private Date birth;
    private String email;
    private String phone;
    private GenderType genderType;
    private YN exjobChk;
    private YN interestChk;
    private String addrCity;
    private String addrProvince;
    private int jobPoint;
    private YN jobInterest;
    private YN dataSharingConsent;
    private List<Long> workHistoryJobs;
    private List<Long> interestJobs;
}
