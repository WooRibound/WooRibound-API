package com.wooribound.api.individual.controller;

import com.wooribound.api.individual.dto.UserApplyDTO;
import com.wooribound.api.individual.dto.UserJobPostingDTO;
import com.wooribound.api.individual.facade.WbUserJobPostingFacade;
import com.wooribound.domain.jobposting.DTO.JobPostingDTO;
import com.wooribound.domain.jobposting.DTO.JobPostingDetailDTO;
import com.wooribound.domain.userapply.Service.UserApplyServiceImpl;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/individualuser/jobposting")
public class WbUserJobPostingController {

    Logger logger = org.slf4j.LoggerFactory.getLogger(UserApplyServiceImpl.class);

    private final WbUserJobPostingFacade wbUserJobPostingFacade;

    // 1. 공고 지원
    @PostMapping("/apply")
    public String updateUserApply(UserApplyDTO userApplyDTO) {
        return wbUserJobPostingFacade.applyForJob(userApplyDTO);
    }

    // 2. 공고 조회 - 전체, 회사명, 직무, 지역
    @PostMapping()
    public List<JobPostingDTO> getJobPostings(@RequestBody(required = false) UserJobPostingDTO userJobPostingDTO) {

        // RequestBody를 null로 받는 경우 빈 객체 생성
        if (userJobPostingDTO != null) {
            logger.info("Received UserJobPostingDTO - entName: {}, jobName: {}, addrCity: {}",
                    userJobPostingDTO.getEntName(), userJobPostingDTO.getJobName(), userJobPostingDTO.getAddrCity());
        } else {
            logger.info("UserJobPostingDTO is null");
        }
        return wbUserJobPostingFacade.getJobPostings(userJobPostingDTO);
    }

    // 3. 공고 상세 조회
    @GetMapping("/detail")
    public JobPostingDetailDTO getJobPostingDetail(@RequestParam Long post_id) {
        return wbUserJobPostingFacade.getJobPostingDetail(post_id);
    }


}
