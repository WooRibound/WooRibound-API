package com.wooribound.api.individual.dto;

import com.wooribound.global.constant.Gender;
import com.wooribound.global.constant.YN;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
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
}
