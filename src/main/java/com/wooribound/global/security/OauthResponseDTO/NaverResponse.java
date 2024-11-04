package com.wooribound.global.security.OauthResponseDTO;

import java.util.Map;

public class NaverResponse implements OAuth2Response {

  private final Map<String, Object> attribute;

  public NaverResponse(Map<String, Object> attribute) {
    this.attribute = (Map<String, Object>) attribute.get("response");
  }

  @Override
  public String getId() {
    return attribute.get("id").toString();
  }

  @Override
  public String getEmail() {
    return attribute.get("email").toString();
  }

  @Override
  public String getName() {
    return attribute.get("name").toString();
  }

  @Override
  public String getGender() {
    return attribute.get("gender").toString();
  }

  @Override
  public String getBirthYear() {
    return attribute.get("birthyear").toString();
  }

  @Override
  public String getBirthDay() {
    return attribute.get("birthday").toString();
  }

  @Override
  public String getPhone() {
    return attribute.get("mobile").toString();
  }


}