package com.wooribound.api.individual.dto;

import lombok.Data;

import java.util.Date;

@Data
public class WbUserUpdateDTO {

    private String userId;
    private String name;
    private Date birth;
    private String phone;
    private String gender;
    private String exjobChk;
    private String jobInterest;
    private String addrCity;
    private String addrProvince;
}
