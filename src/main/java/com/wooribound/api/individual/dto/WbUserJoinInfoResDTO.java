package com.wooribound.api.individual.dto;

import com.wooribound.global.constant.Gender;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class WbUserJoinInfoResDTO {
  private String name;
  private String email;
  private String phone;
  private Gender gender;
  private Date birth;
}
