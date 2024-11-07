package com.wooribound.domain.jobposting.Service;

import com.wooribound.api.corporate.dto.ApplicantsDTO;
import com.wooribound.api.corporate.dto.JobPostingReqDTO;
import com.wooribound.domain.jobposting.dto.JobPostingDetailDTO;
import com.wooribound.domain.jobposting.dto.JobPostingDetailProjection;

import java.util.List;

public interface EntJobPostingService {

    // 1. 공고 등록
    String createJobPosting(JobPostingReqDTO jobPostingReqDTO);

    // 2. 내 기업 공고 목록 조회
    List<JobPostingDetailProjection> getJobPostingList(String entId);

    // 3. 공고 상세 조회
    JobPostingDetailDTO getJobPostingDetail(Long postId);

    // 4. 공고 지원자 전체 조회
    List<ApplicantsDTO> getJobApplicants(int postId);
}