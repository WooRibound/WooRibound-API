package com.wooribound.api.individual.dto;

import com.wooribound.global.constant.GenderType;
import com.wooribound.global.constant.YN;
import java.util.Date;
import java.util.List;
import lombok.Data;

@Data
public class WbUserJoinReqDTO {
  private String name;
  private String email;
  private String phone;
  private GenderType genderType;
  private Date birth;
  private String city;
  private String province;
  private List<Long> selectedInterestJobs;
  private List<Long> selectedJobs;
  private YN dataSharingConsent;
}
