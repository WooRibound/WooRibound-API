package com.wooribound.domain.knowhowreported;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KnowhowReportedRepository extends JpaRepository<KnowhowReported, Long> {
}
