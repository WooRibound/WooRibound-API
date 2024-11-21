package com.wooribound.global.exception;

import lombok.experimental.StandardException;

@StandardException
public class NoEnterpriseException extends RuntimeException{

  public NoEnterpriseException() {
    super("기업회원이 존재하지 않습니다");
  }
}
