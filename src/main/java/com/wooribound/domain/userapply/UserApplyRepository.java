package com.wooribound.domain.userapply;

import com.wooribound.global.constant.ApplyResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserApplyRepository extends JpaRepository<UserApply, Long> {

    // 1. 지원 공고 조회
    List<UserApply> findByWbUser_UserId(String userId);

    // 2. 공고 지원자 전체 조회
    @Query("SELECT ua FROM UserApply ua WHERE ua.jobPosting.postId = :postId and ua.result != 'CANCELED'")
    List<UserApply> findByJobPosting_PostId(int postId);

    // 3. 지원자 결과 설정
    @Modifying
    @Query("UPDATE UserApply ua SET ua.result = :applyResult WHERE ua.applyId = :applyId")
    int setApplicantResult(@Param("applyId") int applyId,
                           @Param("applyResult") ApplyResult applyResult);
}
