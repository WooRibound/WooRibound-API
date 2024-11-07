package com.wooribound.domain.jobposting;

import com.wooribound.domain.jobposting.dto.JobPostingDetailProjection;
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
            "(:addrCity IS NULL OR jp.enterprise.entAddr1 = :addrCity)")
    List<JobPosting> findJobPostings(@Param("entName") String entName,
                                     @Param("jobName") String jobName,
                                     @Param("addrCity") String addrCity);

    // 2. 공고 상세 조회
    JobPosting findJobPostingByPostId(@Param("postId") Long postId);

    // 3. 내 기업 공고 목록 조회
    // JOBPOSTING + COUNT(쿼리연산) 반환해야해서 프로젝션 인터페이스로 리턴값 설정 JobPostingDetailProjection
    @Query("SELECT jp.postTitle AS postTitle, jp.enterprise.entName AS entName, jp.postImg AS postImg, " +
            "jp.startDate AS startDate, jp.endDate AS endDate, jp.postState AS postState, " +
            "jp.job.jobName AS jobName, jp.enterprise.entAddr1 AS entAddr1, jp.enterprise.entAddr2 AS entAddr2, " +
            "(SELECT COUNT(ua) FROM UserApply ua WHERE ua.jobPosting = jp) AS applicantCount " +
            "FROM JobPosting jp " +
            "WHERE jp.enterprise.entId = :entId")
    List<JobPostingDetailProjection> getMyJobPostings(@Param("entId") String entId);

    @Modifying
    int deleteByPostId(Long postId);
}
