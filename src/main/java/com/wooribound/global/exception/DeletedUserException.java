package com.wooribound.global.exception;

import lombok.experimental.StandardException;

@StandardException
public class DeletedUserException extends RuntimeException{
  public DeletedUserException() {
    super("탈퇴한 유저입니다. 회원가입을 새로 진행해 주세요");
  }
}
