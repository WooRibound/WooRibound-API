package com.wooribound.global.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AdminType {

  ROLE_SERVICE_ADMIN("서비스 관리자") ,
  ROLE_INFRA_ADMIN("인프라 관리자");

  private final String text;
}