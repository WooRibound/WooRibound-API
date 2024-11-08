package com.wooribound.global.exception;

public class SaveWorkHistoryException extends  RuntimeException{
  public SaveWorkHistoryException() {
    super("경력 정보를 저장하는데 실패했습니다.");
  }
}
