package com.wooribound.domain.workhistory;

import com.wooribound.domain.workhistory.WorkHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkHistoryRepository extends JpaRepository<WorkHistory, Long> {
  @Modifying
  @Query(value = """
    INSERT INTO work_history (exjob_id, job_id, user_id) 
    VALUES (
        work_history_SEQ.NEXTVAL,
        (SELECT job_id FROM job WHERE CONVERT(job_name, 'UTF8') = CONVERT(:jobName, 'UTF8')), 
        :userId
    )""", nativeQuery = true)
  void saveByJobName(@Param("userId") String userId, @Param("jobName") String jobName);
}
