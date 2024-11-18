package com.wooribound.domain.workhistory;

import com.wooribound.api.individual.dto.JobPostingProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkHistoryRepository extends JpaRepository<WorkHistory, Long> {
  @Modifying
  @Query(value = """
       INSERT INTO work_history (job_id, user_id) 
       VALUES (
           (SELECT job_id FROM job WHERE job_name = :jobName), 
           :userId
       )""", nativeQuery = true)
  void saveByJobName(@Param("userId") String userId, @Param("jobName") String jobName);

  @Query("SELECT wh FROM WorkHistory wh WHERE wh.wbUser.userId = :userId")
  List<WorkHistory> findByUserId(@Param("userId") String userId);

  // 경력직종 조회
  @Query("SELECT wh.job.jobName FROM WorkHistory wh WHERE wh.wbUser.userId = :loginUser")
  List<String> findJobNamesByUserId(String loginUser);

  @Modifying
  @Query("DELETE FROM WorkHistory wh WHERE wh.wbUser.userId = :userId")
  void deleteByUserId(@Param("userId") String userId);
}
