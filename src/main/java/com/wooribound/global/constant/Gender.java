package com.wooribound.global.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Gender {
  M("남자"),
  F("여자"),
  U("미지정");

  private final String text;
}
