package com.wooribound.api.individual.dto;

import com.wooribound.global.constant.Gender;
import com.wooribound.global.constant.YN;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WbUserUpdateDTO {

    private String userId;
    private String name;
    private Date birth;
    private String phone;
    private Gender gender;
    private YN exjobChk;
    private YN jobInterest;
    private String addrCity;
    private String addrProvince;
    private List<String> workHistoryJobs;
    private List<String> interestJobs;
}
