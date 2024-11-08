package com.wooribound.domain.wbuser.dto;

import com.wooribound.global.constant.Gender;
import com.wooribound.global.constant.YN;
import lombok.*;

import java.util.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdminIndividualDTO {
    private String name;
    private Date birth;
    private Gender gender;
    private String addrCity;
}
