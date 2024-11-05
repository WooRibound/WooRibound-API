package com.wooribound.domain.knowhow;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface KnowhowRepository extends JpaRepository<Knowhow, Long> {

    @Query("SELECT k FROM Knowhow k WHERE k.knowhowJob = :knowhowJob AND k.knowhowTitle LIKE %:knowhowTitle%")
    List<Knowhow> findAll(@Param("knowhowJob") String knowhowJob, @Param("knowhowTitle") String knowhowTitle);

    Optional<Knowhow> findByKnowhowId(@Param("knowhowId") Long knowhowId);
}
