package com.wooribound.domain.jobposting;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobPostingRepository extends JpaRepository<JobPosting, Long> {
    // 1. 공고 조회 - 전체, 회사명, 직무, 지역
    @Query("SELECT jp FROM JobPosting jp WHERE " +
            "(:entName IS NULL OR jp.enterprise.entName = :entName) AND " +
            "(:jobName IS NULL OR jp.job.jobName = :jobName) AND " +
            "(:addrCity IS NULL OR jp.enterprise.entAddr = :addrCity)")
    List<JobPosting> findJobPostings(@Param("entName") String entName,
                                     @Param("jobName") String jobName,
                                     @Param("addrCity") String addrCity);

    // 2. 공고 상세 조회
    JobPosting findJobPostingByPostId(@Param("postId") Long postId);

    @Modifying
    int deleteByPostId(Long postId);
}
