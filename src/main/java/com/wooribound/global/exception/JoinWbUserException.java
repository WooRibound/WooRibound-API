package com.wooribound.global.exception;

import lombok.experimental.StandardException;

@StandardException
public class JoinWbUserException extends RuntimeException{
  public JoinWbUserException() {
    super("회원가입에 실패했습니다.");
  }
}
