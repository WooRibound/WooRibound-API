package com.wooribound.domain.jobposting.Service;

import com.wooribound.api.individual.dto.UserJobPostingDTO;
import com.wooribound.domain.jobposting.DTO.WbUserJobPostingDTO;
import com.wooribound.domain.jobposting.DTO.WbUserJobPostingDetailDTO;

import java.util.List;

public interface WbUserJobPostingService {
    // 1. 공고 조회 - 전체, 회사명, 직무, 지역
    List<WbUserJobPostingDTO> getJobPostings(UserJobPostingDTO userJobPostingDTO);

    // 2. 공고 상세 조회
    WbUserJobPostingDetailDTO getJobPostingDetail(Long postId);

}