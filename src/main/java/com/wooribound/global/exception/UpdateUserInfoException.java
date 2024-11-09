package com.wooribound.global.exception;

public class UpdateUserInfoException extends RuntimeException{
  public UpdateUserInfoException() {
    super("회원 정보 설정에 실패하였습니다.");
  }
}
