package com.wooribound.domain.jobposting;

import com.wooribound.api.individual.dto.JobPostingProjection;
import com.wooribound.domain.jobposting.dto.JobPostingDetailProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobPostingRepository extends JpaRepository<JobPosting, Long> {

    @Query("SELECT jp, " +
            "CASE " +
            "WHEN jp.startDate > CURRENT_DATE THEN 'PENDING' " +
            "WHEN jp.startDate <= CURRENT_DATE AND jp.endDate >= CURRENT_DATE THEN 'ACTIVE' " +
            "WHEN jp.endDate < CURRENT_DATE THEN 'CLOSED' " +
            "END AS postState " +
            "FROM JobPosting jp")
    List<JobPostingProjection> findAllJobPostingProjections();

    // 1. 공고 조회 (검색)
    @Query("SELECT jp.enterprise AS enterprise, jp.postId AS postId, jp.enterprise.entName AS entName, jp.postTitle AS postTitle, jp.postImg AS postImg, " +
            "jp.startDate AS startDate, jp.endDate AS endDate, jp.job.jobName AS jobName, " +
            "(CASE " +
            "WHEN jp.startDate > CURRENT_DATE THEN 'PENDING' " +
            "WHEN jp.startDate <= CURRENT_DATE AND jp.endDate >= CURRENT_DATE THEN 'ACTIVE' " +
            "WHEN jp.endDate < CURRENT_DATE THEN 'CLOSED' " +
            "END) AS postState " +
            "FROM JobPosting jp WHERE " +
            "(:entName IS NULL OR jp.enterprise.entName = :entName) AND " +
            "(:jobName IS NULL OR jp.job.jobName = :jobName) AND " +
            "(:entAddr1 IS NULL OR jp.enterprise.entAddr1 = :entAddr1)")
    List<JobPostingProjection> findJobPostings(@Param("entName") String entName,
                                               @Param("jobName") String jobName,
                                               @Param("entAddr1") String entAddr1);

    // 2-1. 공고 조회 (메뉴 접근 - 경력살리기)
    @Query("SELECT jp.enterprise AS enterprise, jp.postId AS postId, jp.enterprise.entName AS entName, jp.postTitle AS postTitle, jp.postImg AS postImg, " +
            "jp.startDate AS startDate, jp.endDate AS endDate, jp.job.jobName AS jobName, " +
            "CASE " +
            "WHEN jp.startDate > CURRENT_DATE THEN 'PENDING' " +
            "WHEN jp.startDate <= CURRENT_DATE AND jp.endDate >= CURRENT_DATE THEN 'ACTIVE' " +
            "WHEN jp.endDate < CURRENT_DATE THEN 'CLOSED' " +
            "END AS postState " +
            "FROM JobPosting jp WHERE " +
            "(:exJobs IS NULL OR jp.job.jobName IN :exJobs)")
    List<JobPostingProjection> findJobPostingsCareer(@Param("exJobs") List<String> exJobs);

    // 2-2. 공고 조회 (메뉴 접근 - 새로운 일 찾기)
    @Query("SELECT jp.enterprise AS enterprise, jp.postId AS postId, jp.enterprise.entName AS entName, jp.postTitle AS postTitle, jp.postImg AS postImg, " +
            "jp.startDate AS startDate, jp.endDate AS endDate, jp.job.jobName AS jobName, " +
            "CASE " +
            "WHEN jp.startDate > CURRENT_DATE THEN 'PENDING' " +
            "WHEN jp.startDate <= CURRENT_DATE AND jp.endDate >= CURRENT_DATE THEN 'ACTIVE' " +
            "WHEN jp.endDate < CURRENT_DATE THEN 'CLOSED' " +
            "END AS postState " +
            "FROM JobPosting jp WHERE " +
            "(:exJobs IS NULL OR jp.job.jobName NOT IN :exJobs) AND " +
            "(:interestJobs IS NULL OR jp.job.jobName IN :interestJobs)")
    List<JobPostingProjection> findJobPostingsNew(@Param("exJobs") List<String> exJobs,
                                                  @Param("interestJobs") List<String> interestJobs);


    // 2. 공고 상세 조회
    JobPosting findJobPostingByPostId(@Param("postId") Long postId);

    // 3. 내 기업 공고 목록 조회
    // JOBPOSTING + COUNT(쿼리연산) 반환해야해서 프로젝션 인터페이스로 리턴값 설정 JobPostingDetailProjection
    @Query("SELECT jp.postTitle AS postTitle, jp.enterprise.entName AS entName, jp.postImg AS postImg, " +
            "jp.startDate AS startDate, jp.endDate AS endDate, " +
            "jp.job.jobName AS jobName, jp.enterprise.entAddr1 AS entAddr1, jp.enterprise.entAddr2 AS entAddr2, " +
            "(SELECT COUNT(ua) FROM UserApply ua WHERE ua.jobPosting = jp) AS applicantCount " +
            "FROM JobPosting jp " +
            "WHERE jp.enterprise.entId = :entId")
    List<JobPostingDetailProjection> getMyJobPostings(@Param("entId") String entId);

    @Modifying
    @Query("UPDATE JobPosting jp SET jp.isDeleted = 'Y' WHERE jp.postId = :postId")
    int updateIsDeletedByPostId(@Param("postId") Long postId);
}
