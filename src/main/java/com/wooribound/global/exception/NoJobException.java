package com.wooribound.global.exception;

import lombok.experimental.StandardException;

@StandardException
public class NoJobException extends RuntimeException {
  public NoJobException(String jobName) {
    super("해당하는 직종이 존재하지 않습니다.");
  }
}