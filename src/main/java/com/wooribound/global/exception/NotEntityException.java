package com.wooribound.global.exception;

public class NotEntityException extends RuntimeException{
    public NotEntityException() {super("존재하는 엔티티가 없습니다.");}
}
