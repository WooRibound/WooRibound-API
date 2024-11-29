package com.wooribound.domain.knowhow;

import com.wooribound.domain.knowhow.dto.AdminKnowhowDetailProjection;
import com.wooribound.domain.knowhow.dto.AdminKnowhowProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface KnowhowRepository extends JpaRepository<Knowhow, Long> {
    // 신고 횟수 기준으로 내림차순
    @Query("SELECT k.knowhowId AS knowhowId, k.knowhowJob AS knowhowJob, " +
            "k.knowhowTitle AS knowhowTitle, k.uploadDate AS uploadDate, " +
            "COUNT(k_report) AS reportedCnt, k.wbUser.userId AS userId, k.wbUser.name AS userName FROM Knowhow k " +
            "LEFT JOIN KnowhowReported k_report ON k_report.knowhow = k " +
            "WHERE (:knowhowTitle IS NULL OR k.knowhowTitle LIKE %:knowhowTitle%) " +
            "AND (:knowhowJob IS NULL OR k.knowhowJob = :knowhowJob) " +
            "GROUP BY k.knowhowId, k.knowhowJob, k.knowhowTitle, k.uploadDate, k.wbUser.userId " +
            "ORDER BY reportedCnt DESC")
    List<AdminKnowhowProjection> findAllWithReportedCntDesc(@Param("knowhowTitle") String knowhowTitle,
                                                            @Param("knowhowJob") String knowhowJob);

    // 신고 횟수 기준으로 오름차순
    @Query("SELECT k.knowhowId AS knowhowId, k.knowhowJob AS knowhowJob, " +
            "k.knowhowTitle AS knowhowTitle, k.uploadDate AS uploadDate, " +
            "COUNT(k_report) AS reportedCnt, k.wbUser.userId AS userId, k.wbUser.name AS userName FROM Knowhow k " +
            "LEFT JOIN KnowhowReported k_report ON k_report.knowhow = k " +
            "WHERE (:knowhowTitle IS NULL OR k.knowhowTitle LIKE %:knowhowTitle%) " +
            "AND (:knowhowJob IS NULL OR k.knowhowJob = :knowhowJob) " +
            "GROUP BY k.knowhowId, k.knowhowJob, k.knowhowTitle, k.uploadDate, k.wbUser.userId " +
            "ORDER BY reportedCnt ASC")
    List<AdminKnowhowProjection> findAllWithReportedCntAsc(@Param("knowhowTitle") String knowhowTitle,
                                                           @Param("knowhowJob") String knowhowJob);

    // 업로드 날짜 기준 내림차순
    @Query("SELECT k.knowhowId AS knowhowId, k.knowhowJob AS knowhowJob, " +
            "k.knowhowTitle AS knowhowTitle, k.uploadDate AS uploadDate, " +
            "COUNT(k_report) AS reportedCnt, k.wbUser.userId AS userId, k.wbUser.name AS userName FROM Knowhow k " +
            "LEFT JOIN KnowhowReported k_report ON k_report.knowhow = k " +
            "WHERE (:knowhowTitle IS NULL OR k.knowhowTitle LIKE %:knowhowTitle%) " +
            "AND (:knowhowJob IS NULL OR k.knowhowJob = :knowhowJob) " +
            "GROUP BY k.knowhowId, k.knowhowJob, k.knowhowTitle, k.uploadDate, k.wbUser.userId " +
            "ORDER BY k.uploadDate DESC")
    List<AdminKnowhowProjection> findAllWithUploadDateDesc(@Param("knowhowTitle") String knowhowTitle,
                                                           @Param("knowhowJob") String knowhowJob);

    // 노하우 상세보기
    @Query("SELECT k.knowhowId AS knowhowId, k.knowhowJob AS knowhowJob, " +
            "k.knowhowTitle AS knowhowTitle, k.uploadDate AS uploadDate, " +
            "k.knowhowContent AS knowhowContent, COUNT(k_report) AS reportedCnt, " +
            "k.wbUser.userId AS userId, k.wbUser.name AS userName FROM Knowhow k " +
            "LEFT JOIN KnowhowReported k_report ON k_report.knowhow = k " +
            "WHERE k.knowhowId = :knowhowId " +
            "GROUP BY k.knowhowId, k.knowhowJob, k.knowhowTitle, k.uploadDate, k.knowhowContent, k.wbUser.userId, k.wbUser.name")
    Optional<AdminKnowhowDetailProjection> findByKnowhowId(@Param("knowhowId") Long knowhowId);

    @Modifying
    int deleteByKnowhowId(Long knowhowId);


    @Query("SELECT k FROM Knowhow k WHERE k.wbUser.userId = :userId " +
            "AND k.knowhowTitle LIKE CONCAT('%', :searchTerm, '%') " +
            "AND (:jobFilter = '전체 직무' OR k.knowhowJob = :jobFilter)")
    List<Knowhow> findByUserIdAndTermAndFilter(@Param("userId") String userId,
                                               @Param("searchTerm") String searchTerm,
                                               @Param("jobFilter") String jobFilter);

    @Query("SELECT k FROM Knowhow k" +
            " WHERE k.knowhowTitle LIKE CONCAT('%', :knowhowTitle, '%') " +
            "AND (:knowhowJob = '전체 직무' OR k.knowhowJob = :knowhowJob) ORDER BY k.uploadDate DESC")
    List<Knowhow> findByKnowhowTitleAndKnowhowJob(@Param("knowhowTitle") String knowhowTitle, @Param("knowhowJob") String knowhowJob);

    @Query("SELECT MAX(k.knowhowId) FROM Knowhow k")
    Optional<Long> getMaxKnowhowId();
}
