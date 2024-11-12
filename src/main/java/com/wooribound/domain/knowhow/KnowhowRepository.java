package com.wooribound.domain.knowhow;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface KnowhowRepository extends JpaRepository<Knowhow, Long> {

    @Query("SELECT k FROM Knowhow k WHERE k.knowhowJob LIKE %:knowhowJob% AND k.knowhowTitle LIKE %:knowhowTitle%")
    List<Knowhow> findAll(@Param("knowhowJob") String knowhowJob, @Param("knowhowTitle") String knowhowTitle);

    Optional<Knowhow> findByKnowhowId(@Param("knowhowId") Long knowhowId);

    @Modifying
    int deleteByKnowhowId(Long knowhowId);


    @Query("SELECT k FROM Knowhow k WHERE k.wbUser.userId = :userId " +
            "AND k.knowhowTitle LIKE CONCAT('%', :searchTerm, '%') " +
            "AND (:jobFilter = '전체 직무' OR k.knowhowJob = :jobFilter)")
    List<Knowhow> findByUserIdAndTermAndFilter(@Param("userId") String userId,
                                               @Param("searchTerm") String searchTerm,
                                               @Param("jobFilter") String jobFilter);

    @Query("SELECT k FROM Knowhow k WHERE k.knowhowTitle LIKE CONCAT('%', :knowhowTitle, '%') AND (:knowhowJob = '전체 직무' OR k.knowhowJob = :knowhowJob)")
    List<Knowhow> findByTermAndFilter(@Param("knowhowTitle") String knowhowTitle, @Param("knowhowJob") String knowhowJob);

    @Query("SELECT MAX(k.knowhowId) FROM Knowhow k")
    Optional<Long> getMaxKnowhowId();
}
