package com.wooribound.domain.jobposting.Service;

import com.wooribound.api.individual.dto.UserJobPostingReqDTO;
import com.wooribound.domain.jobposting.dto.JobPostingDTO;
import com.wooribound.domain.jobposting.dto.JobPostingDetailDTO;

import java.util.List;

public interface WbUserJobPostingService {
    // 1. 공고 조회 - 전체, 회사명, 직무, 지역
    List<JobPostingDTO> getJobPostings(/*String loginUser,*/ UserJobPostingReqDTO userJobPostingReqDTO);
    List<JobPostingDTO> getJobPostingsForNew(UserJobPostingReqDTO userJobPostingReqDTO);
    List<JobPostingDTO> getJobPostingsForCareer(UserJobPostingReqDTO userJobPostingReqDTO);

    // 2. 공고 상세 조회
    JobPostingDetailDTO getJobPostingDetail(Long postId);

}