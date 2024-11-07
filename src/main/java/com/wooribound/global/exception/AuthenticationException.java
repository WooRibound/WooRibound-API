package com.wooribound.global.exception;

import lombok.experimental.StandardException;

@StandardException
public class AuthenticationException extends RuntimeException {
  public AuthenticationException() {
    super("인증정보가 유효하지 않습니다.");
  }
}
