package com.wooribound.domain.userapply;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserApplyRepository extends JpaRepository<UserApply, Long> {

    // 1. 지원 공고 조회
    List<UserApply> findByWbUser_UserId(String userId);

    // 2. 공고 지원자 전체 조회
    List<UserApply> findByJobPosting_PostId(int postId);
}
