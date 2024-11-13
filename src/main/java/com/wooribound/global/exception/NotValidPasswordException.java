package com.wooribound.global.exception;

import lombok.experimental.StandardException;

@StandardException
public class NotValidPasswordException extends RuntimeException{
  public NotValidPasswordException() {
    super("올바른 비밀번호가 아닙니다.");
  }
}
