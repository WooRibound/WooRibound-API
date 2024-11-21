package com.wooribound.global.interceptor.dto;

import com.wooribound.domain.wbuser.WbUser;
import com.wooribound.global.constant.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@AllArgsConstructor
@Data
public class WbUserLogDTO {
    private String userId;
    private String name;
    private Date birth;
    private Gender gender;
    private String addrCity;
    private String addrProvince;


    public static WbUserLogDTO fromEntity (WbUser wbUser) {
        return new WbUserLogDTO(
                wbUser.getUserId(),
                wbUser.getName(),
                wbUser.getBirth(),
                wbUser.getGender(),
                wbUser.getAddrCity(),
                wbUser.getAddrProvince()
        );
    }

}
