package com.wooribound.global.exception;

import lombok.experimental.StandardException;

@StandardException
public class NoKnowhowException extends RuntimeException {
    public NoKnowhowException(Long knowhowId) {
        super(knowhowId + "번 노하우가 존재하지 않습니다.");
    }
}