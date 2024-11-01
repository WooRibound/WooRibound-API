package com.wooribound.domain.individual.repository;

import com.wooribound.domain.individual.entity.WorkHistory;
import lombok.extern.java.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkHistoryRepository extends JpaRepository<WorkHistory, Long> {

}
