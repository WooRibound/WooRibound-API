package com.wooribound.global.security.dto;

import com.wooribound.global.constant.GenderType;

import java.util.Date;

public interface OAuth2Response {

  // 제공자에서 발급해준 ID
  String getId();

  // 이메일
  String getEmail();

  // 사용자 실명
  String getName();

  GenderType getGender();

  Date getBirth();
}
