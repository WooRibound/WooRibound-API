package com.wooribound.global.exception;

public class UnauthorizedAccessException extends RuntimeException{
    public UnauthorizedAccessException(){super("권한이없는 사용자 입니다.");}
}
