package com.wooribound.api.individual.controller;

import com.wooribound.api.individual.dto.UserApplyDTO;
import com.wooribound.api.individual.dto.UserJobPostingReqDTO;
import com.wooribound.api.individual.facade.WbUserJobPostingFacade;
import com.wooribound.domain.jobposting.dto.JobPostingDTO;
import com.wooribound.domain.jobposting.dto.JobPostingDetailDTO;
import com.wooribound.domain.userapply.Service.UserApplyServiceImpl;
import com.wooribound.global.util.AuthenticateUtil;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/individualuser/jobposting")
public class WbUserJobPostingController {

    Logger logger = org.slf4j.LoggerFactory.getLogger(UserApplyServiceImpl.class);

    private final WbUserJobPostingFacade wbUserJobPostingFacade;
    private final AuthenticateUtil authenticateUtil;

    // 1. 공고 지원
    @PostMapping("/apply")
    public String updateUserApply(UserApplyDTO userApplyDTO) {
        return wbUserJobPostingFacade.applyForJob(userApplyDTO);
    }

    // 2. 공고 조회 - 검색 (회사명, 직무, 지역)
    @PostMapping()
    public List<JobPostingDTO> getJobPostings(Authentication authentication,
                                              @RequestBody(required = false) UserJobPostingReqDTO userJobPostingReqDTO) {

        // RequestBody를 null로 받는 경우 빈 객체 생성
        if (userJobPostingReqDTO != null) {
            logger.info("Received UserJobPostingDTO - entName: {}, jobName: {}, entAddr1: {}",
                    userJobPostingReqDTO.getEntName(), userJobPostingReqDTO.getJobName(), userJobPostingReqDTO.getEntAddr1());
        } else {
            logger.info("UserJobPostingDTO is null");
        }
        return wbUserJobPostingFacade.getJobPostings(authentication, userJobPostingReqDTO);
    }

    // 2-1. 공고 조회 - 새로운 일 구하기
    @PostMapping("/new")
    public List<JobPostingDTO> getJobPostingsForNew(Authentication authentication, @RequestBody UserJobPostingReqDTO userJobPostingReqDTO) {
        userJobPostingReqDTO.setViewType("new");
        return wbUserJobPostingFacade.getJobPostingsForNew(authentication, userJobPostingReqDTO);
    }

    // 2-2. 공고 조회 - 경력 살리기
    @PostMapping("/career")
    public List<JobPostingDTO> getJobPostingsForCareer(Authentication authentication, @RequestBody UserJobPostingReqDTO userJobPostingReqDTO) {
        userJobPostingReqDTO.setViewType("career");
        return wbUserJobPostingFacade.getJobPostingsForCareer(authentication, userJobPostingReqDTO);
    }

    // 3. 공고 상세 조회
    @GetMapping("/detail")
    public JobPostingDetailDTO getJobPostingDetail(@RequestParam Long postId) {
        return wbUserJobPostingFacade.getJobPostingDetail(postId);
    }


}
