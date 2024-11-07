package com.wooribound.domain.enterprise;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface EnterpriseRepository extends JpaRepository<Enterprise, String> {
    @Transactional
    @Modifying
    int deleteByEntId(String entId);

    @Modifying
    @Transactional
    @Query("UPDATE Enterprise e SET e.isDeleted = 'Y', e.updatedAt = CURRENT_TIMESTAMP WHERE e.entId = :entId")
    int updateIsDeleted(@Param("entId") String entId);
}
