package com.wooribound.domain.jobposting.Service;

import com.wooribound.api.individual.dto.UserJobPostingDTO;
import com.wooribound.domain.jobposting.dto.JobPostingDTO;
import com.wooribound.domain.jobposting.dto.JobPostingDetailDTO;

import java.util.List;

public interface WbUserJobPostingService {
    // 1. 공고 조회 - 전체, 회사명, 직무, 지역
    List<JobPostingDTO> getJobPostings(UserJobPostingDTO userJobPostingDTO);

    // 2. 공고 상세 조회
    JobPostingDetailDTO getJobPostingDetail(Long postId);

}