package com.wooribound.domain.enterprise;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EnterpriseRepository extends JpaRepository<Enterprise, String> {
    // 기업 회원 목록 조회
    @Query("SELECT e FROM Enterprise e " +
            "WHERE (:entName IS NULL OR e.entName LIKE CONCAT('%', :entName, '%')) " +
            "AND (:entField IS NULL OR e.entField = :entField) " +
            "AND (:addrCity IS NULL OR e.entAddr1 LIKE CONCAT('%', :addrCity, '%')) " +
            "AND e.isDeleted IN ('N', 'P') " +
            "AND e.updatedAt IS NOT NULL")
    List<Enterprise> findEnterprises(@Param("entName") String entName,
                                     @Param("entField") String entField,
                                     @Param("addrCity") String addrCity);

    // 기업회원 상세 정보 조회
    Optional<Enterprise> findByEntId(String entId);

    // 가입 승인 대기 중인 기업회원 목록 조회
    @Query("SELECT e FROM Enterprise e " +
            "WHERE (:entName IS NULL OR e.entName LIKE CONCAT('%', :entName, '%')) " +
            "AND e.updatedAt IS NULL")
    List<Enterprise> findPendingRegist(@Param("entName") String entName);

    // 기업회원 회원 가입 승인
    @Modifying
    @Query("UPDATE Enterprise e SET e.updatedAt = CURRENT_TIMESTAMP WHERE e.entId = :entId")
    int updateUpdatedAt(@Param("entId") String entId);

    // 기업회원 가입 반려
    @Modifying
    int deleteByEntId(String entId);

    // 탈퇴 승인 대기 중인 기업회원 목록 조회
    @Query("SELECT e FROM Enterprise e " +
            "WHERE (:entName IS NULL OR e.entName LIKE CONCAT('%', :entName, '%')) " +
            "AND e.isDeleted = 'P'")
    List<Enterprise> findPendingDeletion(String entName);

    // 기업회원 탈퇴 승인
    @Modifying
    @Query("UPDATE Enterprise e SET e.isDeleted = 'Y', e.updatedAt = CURRENT_TIMESTAMP WHERE e.entId = :entId")
    int updateIsDeleted(@Param("entId") String entId);

    // 기업회원 탈퇴 반려
    @Modifying
    @Query("UPDATE Enterprise e SET e.isDeleted = 'N', e.updatedAt = CURRENT_TIMESTAMP, e.deleteRequestedAt = NULL WHERE e.entId = :entId")
    int updateDeleteRequestedAt(String entId);
}
