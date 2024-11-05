package com.wooribound.global.security.OauthResponseDTO;

import com.wooribound.global.constant.Gender;
import java.util.Date;

public interface OAuth2Response {

  // 제공자에서 발급해준 ID
  String getId();

  // 이메일
  String getEmail();

  // 사용자 실명
  String getName();

  Gender getGender();

  Date getBirth();

  String getPhone();
}
