package com.wooribound.global.exception;

import lombok.experimental.StandardException;

@StandardException
public class NoWbUserException extends RuntimeException{

  public NoWbUserException() {
    super("회원이 존재하지 않습니다");
  }
}
