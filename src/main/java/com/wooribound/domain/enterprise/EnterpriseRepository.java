package com.wooribound.domain.enterprise;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface EnterpriseRepository extends JpaRepository<Enterprise, String> {
    @Transactional
    @Modifying
    int deleteByEntId(String entId);
}
