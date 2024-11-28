package com.wooribound.global.exception;

public class UserRegistrationApprovalException extends RuntimeException{
    public  UserRegistrationApprovalException() {super("아직 가입승인 또는 탈퇴승인 처리중입니다. 관리자에게 문의해주세요.");}
}
