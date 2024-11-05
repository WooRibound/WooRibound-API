package com.wooribound.api.individual.controller;

import com.wooribound.api.individual.dto.UserApplyDTO;
import com.wooribound.api.individual.dto.UserJobPostingDTO;
import com.wooribound.api.individual.facade.WbUserJobPostingFacade;
import com.wooribound.domain.jobposting.DTO.WbUserJobPostingDTO;
import com.wooribound.domain.jobposting.DTO.WbUserJobPostingDetailDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/individualuser/jobposting")
public class WbUserJobPostingController {

    private final WbUserJobPostingFacade wbUserJobPostingFacade;

    // 1. 공고 지원
    @PostMapping("apply")
    public String updateUserApply(UserApplyDTO userApplyDTO) {
        return wbUserJobPostingFacade.applyForJob(userApplyDTO);
    }

    // 2. 공고 조회 - 전체, 회사명, 직무, 지역
    @GetMapping()
    public List<WbUserJobPostingDTO> getJobPostings(@RequestBody(required = false) UserJobPostingDTO userJobPostingDTO) {
        return wbUserJobPostingFacade.getJobPostings(userJobPostingDTO);
    }

    // 3. 공고 상세 조회
    @GetMapping("detail")
    public WbUserJobPostingDetailDTO getJobPostingDetail(@RequestParam Long post_id) {
        return wbUserJobPostingFacade.getJobPostingDetail(post_id);
    }


}
