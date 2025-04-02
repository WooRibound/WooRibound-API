package com.wooribound.global.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EnterpriseDeletionStatus {

  Y("탈퇴 회원"),
  N("활동 회원"),
  P("탈퇴처리 중");

  private final String text;
}
