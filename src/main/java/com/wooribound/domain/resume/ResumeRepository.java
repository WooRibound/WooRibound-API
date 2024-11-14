package com.wooribound.domain.resume;

import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ResumeRepository extends JpaRepository<Resume, Long> {
    @Query("SELECT r FROM Resume r WHERE r.wbUser.userId = :userId")
    Optional<Resume> findByUserId(@Param("userId") String userId);

    @Query("SELECT MAX(r.resumeId) FROM Resume r")
    Optional<Long> getMaxResumeId();
}
