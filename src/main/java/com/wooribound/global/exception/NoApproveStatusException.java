package com.wooribound.global.exception;

import lombok.experimental.StandardException;

@StandardException
public class NoApproveStatusException extends RuntimeException{
  public NoApproveStatusException() {
    super("잘못된 기업회원 가입 승인 요청입니다. 다시 시도해주세요");
  }
}
