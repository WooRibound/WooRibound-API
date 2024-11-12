package com.wooribound.global.exception;

import lombok.experimental.StandardException;
@StandardException
public class DuplicatedIdException extends RuntimeException {
  public DuplicatedIdException(String id) {
    super(id+"는 이미 사용중인 id 입니다.");
  }
}



