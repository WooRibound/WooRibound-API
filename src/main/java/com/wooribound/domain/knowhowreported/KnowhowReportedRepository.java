package com.wooribound.domain.knowhowreported;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KnowhowReportedRepository extends JpaRepository<KnowhowReported, Long> {
    @Query("SELECT MAX(kr.reportedId) FROM KnowhowReported kr")
    Optional<Long> getMaxReportedId();
}
