package com.wooribound.global.exception;

import lombok.experimental.StandardException;

@StandardException
public class NoUserApplyException extends RuntimeException {

    public NoUserApplyException(Long postId) {
        super("채용공고 " + postId + "에 대한 지원자가 없거나 지원 취소 처리에 실패했습니다.");
    }
}