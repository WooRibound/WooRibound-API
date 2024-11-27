package com.wooribound.domain.jobposting;

import com.wooribound.api.corporate.dto.ApplicantsDTO;
import com.wooribound.api.corporate.dto.RecommendationHistoryDTO;
import com.wooribound.api.individual.dto.JobPostingProjection;
import com.wooribound.domain.employment.Employment;
import com.wooribound.domain.jobposting.dto.JobPostingDetailProjection;
import com.wooribound.domain.jobposting.dto.WbUserProjection;
import com.wooribound.domain.wbuser.WbUser;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JobPostingRepository extends JpaRepository<JobPosting, Long> {

    @Query("SELECT jp.enterprise AS enterprise, jp.postId AS postId, jp.enterprise.entName AS entName, jp.postTitle AS postTitle, jp.postImg AS postImg, " +
            "jp.startDate AS startDate, jp.endDate AS endDate, jp.job.jobName AS jobName, " +
            "(CASE " +
            "WHEN jp.startDate > CURRENT_DATE THEN 'PENDING' " +
            "WHEN jp.startDate <= CURRENT_DATE AND jp.endDate >= CURRENT_DATE THEN 'ACTIVE' " +
            "WHEN jp.endDate < CURRENT_DATE THEN 'CLOSED' " +
            "END) AS postState " +
            "FROM JobPosting jp" +
            " ORDER BY jp.createdAt DESC")
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
            "(:entName IS NULL OR jp.enterprise.entName LIKE %:entName%) AND " +
            "(:jobName IS NULL OR jp.job.jobName = :jobName) AND " +
            "(:entAddr1 IS NULL OR jp.enterprise.entAddr1 = :entAddr1) AND " +
            "(jp.isDeleted = 'N')" +
            "ORDER BY jp.createdAt DESC")
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
            "(:exJobs IS NULL OR jp.job.jobName IN :exJobs)" +
            "ORDER BY jp.createdAt DESC")
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
    Optional<JobPosting> findJobPostingByPostId(@Param("postId") Long postId);

    // 3. 내 기업 공고 목록 조회
    @Query("SELECT jp.postId AS postId, jp.postTitle AS postTitle, jp.enterprise.entName AS entName, jp.postImg AS postImg, " +
            "jp.startDate AS startDate, jp.endDate AS endDate, " +
            "jp.job.jobName AS jobName, jp.enterprise.entAddr1 AS entAddr1, jp.enterprise.entAddr2 AS entAddr2, " +
            "(SELECT COUNT(ua) FROM UserApply ua WHERE ua.jobPosting = jp) AS applicantCount, " +
            "CASE " +
            "WHEN FUNCTION('DATE', jp.startDate) <= CURRENT_DATE AND FUNCTION('DATE', jp.endDate) >= CURRENT_DATE THEN 'ACTIVE' " +
            "WHEN FUNCTION('DATE', jp.startDate) > CURRENT_DATE THEN 'PENDING' " +
            "WHEN FUNCTION('DATE', jp.endDate) < CURRENT_DATE THEN 'CLOSED' " +
            "END AS postState " +
            "FROM JobPosting jp " +
            "WHERE jp.enterprise.entId = :entId AND jp.isDeleted = 'N' " +
            "ORDER BY jp.createdAt DESC")
    List<JobPostingDetailProjection> getMyJobPostings(@Param("entId") String entId);


    @Modifying
    @Query("UPDATE JobPosting jp SET jp.isDeleted = 'Y' WHERE jp.postId = :postId")
    int updateIsDeletedByPostId(@Param("postId") Long postId);

    // 6. 공고별 지원자 추천 (헤드헌팅기능)
    @Query("""
                SELECT 
                    w.userId AS userId, 
                    w.name AS name, 
                    CAST(w.birth AS date) AS birth, 
                    w.gender AS gender, 
                    SUM(CASE WHEN e.empRecomm = 'Y' THEN 1 ELSE 0 
                        END) AS recommCount 
                FROM WbUser w JOIN w.workHistories wh 
                LEFT JOIN Employment e ON e.wbUser.userId = w.userId 
                WHERE wh.job.jobId = :jobId 
                    AND w.exjobChk = 'Y' 
                    AND w.dataSharingConsent = 'Y'
                GROUP BY w.userId, w.name, w.birth, w.gender, w.jobPoint 
                ORDER BY w.jobPoint DESC, recommCount DESC
            """)
    List<WbUserProjection> findApplicantRecommendation(@Param("jobId") int jobId);

    // 6-1. 기업 추천 내역 조회 (프리미엄 기능)
    @Query("SELECT emp as entName FROM Employment emp WHERE emp.wbUser.userId = :userId AND emp.empRecomm = 'Y'")
    List<Employment> findRecommendationHistory(String userId);

    @Query("SELECT MAX(jp.postId) FROM JobPosting jp")
    Optional<Long> getMaxJobPostingId();

    @Query("SELECT MAX(jp.postingCnt) FROM JobPosting jp")
    Optional<Long> getMaxPostingCnt();

    @Query("SELECT jp.enterprise AS enterprise, jp.postId AS postId, jp.enterprise.entName AS entName, jp.postTitle AS postTitle, jp.postImg AS postImg, " +
            "jp.startDate AS startDate, jp.endDate AS endDate, jp.job.jobName AS jobName, " +
            "CASE " +
            "WHEN jp.startDate > CURRENT_DATE AND jp.endDate >= CURRENT_DATE THEN 'PENDING' " +
            "WHEN jp.startDate <= CURRENT_DATE AND jp.endDate >= CURRENT_DATE THEN 'ACTIVE' " +
            "WHEN jp.endDate < CURRENT_DATE THEN 'CLOSED' END AS postState " +
            "FROM JobPosting jp " +
            "WHERE (jp.startDate <= CURRENT_DATE AND jp.endDate >= CURRENT_DATE) OR jp.startDate > CURRENT_DATE " +
            "ORDER BY jp.postingCnt DESC ")
    List<JobPostingProjection> findByOrderByPostingCntDesc(Pageable pageable);

    @Query("SELECT jp.enterprise AS enterprise, jp.postId AS postId, jp.enterprise.entName AS entName, jp.postTitle AS postTitle, jp.postImg AS postImg, " +
            "jp.startDate AS startDate, jp.endDate AS endDate, jp.job.jobName AS jobName, " +
            "CASE " +
            "WHEN jp.startDate > CURRENT_DATE AND jp.endDate >= CURRENT_DATE THEN 'PENDING' " +
            "WHEN jp.startDate <= CURRENT_DATE AND jp.endDate >= CURRENT_DATE THEN 'ACTIVE' " +
            "WHEN jp.endDate < CURRENT_DATE THEN 'CLOSED' END AS postState " +
            "FROM JobPosting jp " +
            "ORDER BY jp.createdAt DESC ")
    List<JobPostingProjection> findByOrderByCreatedAtDesc(Pageable pageable);


}
