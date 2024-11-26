package com.wooribound.global.exception;

import lombok.experimental.StandardException;

@StandardException
public class NoAdminException extends RuntimeException{

  public NoAdminException() {
    super("관리자가 존재하지 않습니다");
  }
}
