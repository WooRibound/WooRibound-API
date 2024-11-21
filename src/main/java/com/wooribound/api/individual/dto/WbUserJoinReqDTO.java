package com.wooribound.api.individual.dto;

import com.wooribound.global.constant.Gender;
import com.wooribound.global.constant.YN;
import java.util.Date;
import java.util.List;
import lombok.Data;
import lombok.Getter;

@Data
public class WbUserJoinReqDTO {
  private String name;
  private String email;
  private String phone;
  private Gender gender;
  private Date birth;
  private String city;
  private String province;
  private List<Long> selectedInterestJobs;
  private List<Long> selectedJobs;
  private YN dataSharingConsent;
}
