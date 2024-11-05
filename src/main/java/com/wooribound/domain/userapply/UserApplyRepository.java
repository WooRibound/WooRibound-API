package com.wooribound.domain.userapply;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserApplyRepository extends JpaRepository<UserApply, Long> {

    // 1. 지원 공고 조회
    List<UserApply> findByWbUser_UserId(String userId);

}
