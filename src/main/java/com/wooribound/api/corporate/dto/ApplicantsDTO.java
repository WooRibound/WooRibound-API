package com.wooribound.api.corporate.dto;

import com.wooribound.global.constant.ApplyStatus;
import com.wooribound.global.constant.GenderType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class ApplicantsDTO {

    private String applicantName;
    private GenderType applicantGenderType;
    private int applicantAge;
    private String userId;
    private Long applyId;
    private ApplyStatus result;
    private int recommendCount;

}
