package com.wooribound.global.exception;

public class SaveInterestingJobException extends RuntimeException {
  public SaveInterestingJobException() {
    super("관심직종을 저장하는데 실패했습니다.");
  }
}
