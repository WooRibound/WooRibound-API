package com.wooribound.api.individual.dto;

import com.wooribound.global.constant.YN;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OAuthDTO {
  private String id;
  private String name;
  private YN FirstLogin;
}
