package com.wooribound.domain.workhistory;

import com.wooribound.domain.workhistory.WorkHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkHistoryRepository extends JpaRepository<WorkHistory, Long> {

    @Query("SELECT wh FROM WorkHistory wh WHERE wh.wbUser.userId = :userId")
    List<WorkHistory> findByUserId(@Param("userId") String userId);

}
