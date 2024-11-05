package com.wooribound.api.individual.facade;

import com.wooribound.api.individual.dto.UserApplyDTO;
import com.wooribound.api.individual.dto.UserJobPostingDTO;
import com.wooribound.domain.jobposting.DTO.WbUserJobPostingDTO;
import com.wooribound.domain.jobposting.DTO.WbUserJobPostingDetailDTO;
import com.wooribound.domain.jobposting.Service.WbUserJobPostingService;
import com.wooribound.domain.userapply.Service.UserApplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class WbUserJobPostingFacade {

    private final UserApplyService userApplyService;
    private final WbUserJobPostingService wbUserJobPostingService;

    // 1. 공고 지원
    public String applyForJob(UserApplyDTO userApplyDTO) {
        return userApplyService.createUserApply(userApplyDTO);
    }

    // 2. 공고 조회 - 전체, 회사명, 직무, 지역
    public List<WbUserJobPostingDTO> getJobPostings(UserJobPostingDTO userJobPostingDTO) {
        return wbUserJobPostingService.getJobPostings(userJobPostingDTO);
    }

    // 3. 공고 상세 조회
    public WbUserJobPostingDetailDTO getJobPostingDetail(Long postId) {
        return wbUserJobPostingService.getJobPostingDetail(postId);
    }

}