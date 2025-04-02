package com.wooribound.global.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EnterpriseSize {
  STARTUP("스타트업"),
  SMALL("중소기업"),
  MEDIUM("중견기업"),
  LARGE("대기업");

  private final String text;
}
