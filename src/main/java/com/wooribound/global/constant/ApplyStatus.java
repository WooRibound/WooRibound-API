package com.wooribound.global.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ApplyStatus {

  PENDING("결과 대기중"),
  ACCEPTED("합격"),
  REJECTED("불합격"),
  CANCELED("지원 취소");

  private final String text;
}
