package com.wooribound.api.corporate.dto;

import com.wooribound.global.constant.Gender;
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
    private Gender applicantGender;
    private int applicantAge;
}
