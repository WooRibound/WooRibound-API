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
    INSERT INTO interest_job (interest_id, job_id, user_id) 
    VALUES (
        interest_job_SEQ.NEXTVAL,
        (SELECT job_id FROM job WHERE CONVERT(job_name, 'UTF8') = CONVERT(:jobName, 'UTF8')), 
        :userId
    )""", nativeQuery = true)
  void saveInterestJob(@Param("userId") String userId, @Param("jobName") String jobName);

  @Query("SELECT ij.job.jobName FROM InterestJob ij WHERE ij.wbUser.userId = :userId")
  List<String> findJobNamesByUserId(@Param("userId") String userId);

  @Modifying
  @Query("DELETE FROM InterestJob w WHERE w.wbUser.userId = :userId")
  void deleteByUserId(@Param("userId") String userId);
}
