package com.wooribound.domain.jobposting.Service;

import com.wooribound.api.corporate.dto.ApplicantsDTO;
import com.wooribound.api.corporate.dto.JobPostingReqDTO;
import com.wooribound.domain.jobposting.dto.JobPostingDetailDTO;
import com.wooribound.domain.jobposting.dto.JobPostingDetailProjection;
import com.wooribound.domain.userapply.dto.ApplicantResultReqDTO;

import java.util.List;

public interface EntJobPostingService {

    // 1. 공고 등록
    String createJobPosting(JobPostingReqDTO jobPostingReqDTO);

    // 2. 내 기업 공고 목록 조회
    List<JobPostingDetailDTO> getJobPostingList(String entId);

    // 3. 공고 상세 조회
    JobPostingDetailDTO getJobPostingDetail(Long postId);

    // 4. 공고 지원자 전체 조회
    List<ApplicantsDTO> getJobApplicants(int postId);

    // 5. 지원자 결과 설정
    String setApplicantResult(ApplicantResultReqDTO applicantResultReqDTO);

    // 6. 공고별 지원자 추천 (헤드헌팅기능)
    List<ApplicantsDTO> getApplicantRecommendation(int jobId);
}