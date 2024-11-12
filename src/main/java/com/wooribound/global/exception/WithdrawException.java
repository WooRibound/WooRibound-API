package com.wooribound.global.exception;

import lombok.experimental.StandardException;

@StandardException
public class WithdrawException extends RuntimeException {
  public WithdrawException() {super("회원 탈퇴 중 알수없는 오류가 발생했습니다.");}
}
