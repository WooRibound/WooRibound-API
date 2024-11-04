package com.wooribound.domain.workhistory;

import com.wooribound.domain.workhistory.WorkHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkHistoryRepository extends JpaRepository<WorkHistory, Long> {

}
