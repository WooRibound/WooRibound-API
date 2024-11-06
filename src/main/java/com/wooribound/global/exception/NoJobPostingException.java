package com.wooribound.global.exception;

import lombok.experimental.StandardException;

@StandardException
public class NoJobPostingException extends RuntimeException {
    public NoJobPostingException(Long postId) {
        super(postId + "번 채용공고가 존재하지 않습니다.");
    }
}