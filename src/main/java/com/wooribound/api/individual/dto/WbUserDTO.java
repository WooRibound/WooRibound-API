package com.wooribound.api.individual.dto;

import com.wooribound.global.constant.Gender;
import com.wooribound.global.constant.YN;

import lombok.*;

import java.util.Date;

@Data
@Builder
public class WbUserDTO {
    private String userId;
    private String name;
    private Date birth;
    private String email;
    private String phone;
    private Gender gender;
    private YN exjobChk;
    private YN interestChk;
    private String addrCity;
    private String addrProvince;
    private int jobPoint;
    private YN jobInterest;
    private Date createdAt;
    private Date updatedAt;
    private YN isDeleted;
}
