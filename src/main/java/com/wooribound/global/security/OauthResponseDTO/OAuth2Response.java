package com.wooribound.global.security.OauthResponseDTO;

public interface OAuth2Response {

  // 제공자에서 발급해준 ID
  String getId();

  // 이메일
  String getEmail();

  // 사용자 실명
  String getName();

  String getGender();

  String getBirthYear();

  String getBirthDay();

  String getPhone();
}
