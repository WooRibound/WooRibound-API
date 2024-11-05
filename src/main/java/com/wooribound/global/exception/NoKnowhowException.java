package com.wooribound.global.exception;

import lombok.experimental.StandardException;

@StandardException
public class NoKnowhowException extends RuntimeException{

  public NoKnowhowException() {
    super("해당 ID의 지식이 존재하지 않습니다");
  }
}
