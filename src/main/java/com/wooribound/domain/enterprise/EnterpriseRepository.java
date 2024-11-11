package com.wooribound.domain.enterprise;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnterpriseRepository extends JpaRepository<Enterprise, String> {
    @Modifying
    int deleteByEntId(String entId);

    @Modifying
    @Query("UPDATE Enterprise e SET e.isDeleted = 'Y', e.updatedAt = CURRENT_TIMESTAMP WHERE e.entId = :entId")
    int updateIsDeleted(@Param("entId") String entId);

    @Query("SELECT e FROM Enterprise e " +
            "WHERE (:entName IS NULL OR e.entName LIKE CONCAT('%', :entName, '%')) " +
            "AND (:entField IS NULL OR e.entField = :entField)" +
            "AND (:addrCity IS NULL OR e.entAddr1 = :addrCity)")
    List<Enterprise> findEnterprises(@Param("entName") String entName, @Param("entField") String entField, @Param("addrCity") String addrCity);

    Enterprise findByEntId(String entId);

    @Query("SELECT e FROM Enterprise e " +
            "WHERE (:entName IS NULL OR e.entName LIKE CONCAT('%', :entName, '%')) " +
            "AND e.updatedAt IS NULL")
    List<Enterprise> findRegistPending(String entName);
}
