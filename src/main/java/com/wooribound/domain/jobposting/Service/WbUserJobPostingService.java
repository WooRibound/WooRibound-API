package com.wooribound.domain.jobposting.Service;

import com.wooribound.api.individual.dto.UserJobPostingReqDTO;
import com.wooribound.domain.jobposting.dto.JobPostingDTO;
import com.wooribound.domain.jobposting.dto.JobPostingDetailDTO;

import java.util.List;

public interface WbUserJobPostingService {
    // 1. 공고 조회 - 검색, 새로운 일 구하기, 경력 살리기
    List<JobPostingDTO> getJobPostings(UserJobPostingReqDTO userJobPostingReqDTO);
    List<JobPostingDTO> getJobPostingsForNew(String loginId, UserJobPostingReqDTO userJobPostingReqDTO);
    List<JobPostingDTO> getJobPostingsForCareer(String loginId, UserJobPostingReqDTO userJobPostingReqDTO);

    // 2. 공고 상세 조회
    JobPostingDetailDTO getJobPostingDetail(Long postId);

    // 추천 공고 조회
    List<JobPostingDTO> getRecommendedJobPostings();
    List<JobPostingDTO> getRecentJobPostings();

}