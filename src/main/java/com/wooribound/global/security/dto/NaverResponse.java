package com.wooribound.global.security.dto;

import com.wooribound.global.constant.Gender;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    Object email = attribute.get("email");
    if (email == null){
      return null;
    } else {
      return email.toString();
    }

  }

  @Override
  public String getName() {
    return attribute.get("name").toString();
  }

  @Override
  public Gender getGender() {
    Object gender = attribute.get("gender");
    if (gender == null){
      return Gender.U;
    } else {
      return Gender.valueOf(gender.toString().toUpperCase());
    }
  }

  @Override
  public Date getBirth() {
    String year = attribute.get("birthyear") != null ? attribute.get("birthyear").toString() : null; // 예: "2024"
    String day = attribute.get("birthday") != null ? attribute.get("birthday").toString() : null;   // 예: "12-31"

    // year 또는 day가 null인 경우 null 반환
    if (year == null || day == null) {
      return null;
    }

    // year와 day를 합쳐서 "yyyy-MM-dd" 형식으로 변환
    String birthDateString = year + "-" + day; // 예: "2024-12-31"

    // 날짜 형식으로 변환
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date birthDate = null;

    try {
      birthDate = dateFormat.parse(birthDateString);
    } catch (ParseException e) {
      e.printStackTrace(); // 예외 처리
    }

    return birthDate; // Date 형식으로 반환
  }


  @Override
  public String getPhone() {
    // mobile이 null일 경우 null 반환
    Object mobile = attribute.get("mobile");
    return mobile != null ? mobile.toString() : null;
  }


}