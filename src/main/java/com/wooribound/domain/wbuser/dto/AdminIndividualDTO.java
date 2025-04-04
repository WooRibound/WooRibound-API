package com.wooribound.domain.wbuser.dto;

import com.wooribound.global.constant.GenderType;
import lombok.*;

import java.util.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdminIndividualDTO {
    private String userId;
    private String name;
    private Date birth;
    private GenderType genderType;
    private String addrCity;
}
