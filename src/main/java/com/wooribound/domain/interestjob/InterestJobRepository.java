package com.wooribound.domain.interestjob;

import com.wooribound.domain.interestjob.InterestJob;

import java.util.List;
import java.util.Optional;

import com.wooribound.domain.job.JobDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface InterestJobRepository extends JpaRepository<InterestJob, Long> {
  @Modifying
  @Query(value = """
       INSERT INTO interest_job (job_id, user_id) 
       VALUES (
           (SELECT job_id FROM job WHERE job_id = :jobId), 
           :userId
       )""", nativeQuery = true)
  void saveInterestJob(@Param("userId") String userId, @Param("jobId") Long jobId);

  @Query("SELECT ij.job.jobName FROM InterestJob ij WHERE ij.wbUser.userId = :userId")
  List<String> findJobNamesByUserId(@Param("userId") String userId);

  @Modifying
  @Query("DELETE FROM InterestJob ij WHERE ij.wbUser.userId = :userId")
  void deleteByUserId(@Param("userId") String userId);
}
