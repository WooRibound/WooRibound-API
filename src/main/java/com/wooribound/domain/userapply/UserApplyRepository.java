package com.wooribound.domain.userapply;

import com.wooribound.domain.enterprise.dto.UserApplyProjection;
import com.wooribound.global.constant.ApplyResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserApplyRepository extends JpaRepository<UserApply, Long> {

    // 1. 지원 공고 조회
    List<UserApply> findByWbUser_UserId(String userId);

    // 2. 공고 지원자 전체 조회
    @Query("""
                SELECT 
                    ua.applyId AS applyId,
                    ua.wbUser.birth AS birth,
                    ua.wbUser.gender AS gender,
                    ua.wbUser.name AS name,
                    ua.wbUser.userId AS userId,
                    ua.result AS result,
                    COALESCE((
                        SELECT COUNT(e.empId) 
                        FROM Employment e 
                        WHERE e.wbUser.userId = ua.wbUser.userId 
                          AND e.empRecomm = 'Y'
                    ), 0) AS recommendCount
                FROM UserApply ua
                WHERE ua.jobPosting.postId = :postId 
                  AND ua.result != 'CANCELED'
            """)
    List<UserApplyProjection> findByJobPosting_PostId(int postId);


    // 3. 지원자 결과 설정
    @Modifying
    @Query("UPDATE UserApply ua SET ua.result = :applyResult WHERE ua.applyId = :applyId")
    int setApplicantResult(@Param("applyId") Long applyId,
                           @Param("applyResult") ApplyResult applyResult);

    // 4. 지원 결과 대기 중인 지원현황 조회
    @Query("SELECT ua FROM UserApply ua WHERE ua.jobPosting.postId = :postId AND ua.result = 'PENDING'")
    List<UserApply> findUserApply(Long postId);

    // 4 - 1. 지원 결과 취소로 업데이트
    @Modifying
    @Query("UPDATE UserApply ua SET ua.result = 'CANCELED' WHERE ua.jobPosting.postId = :postId AND ua.result = 'PENDING'")
    int cancelUserApplyByPostId(@Param("postId") Long postId);

    @Query("SELECT MAX(u.applyId) FROM UserApply u")
    Optional<Long> getMaxUserApplyId();

}
