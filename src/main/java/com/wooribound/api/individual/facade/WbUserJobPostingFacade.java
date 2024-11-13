package com.wooribound.api.individual.facade;

import com.wooribound.api.individual.dto.UserApplyDTO;
import com.wooribound.api.individual.dto.UserJobPostingReqDTO;
import com.wooribound.domain.jobposting.Service.WbUserJobPostingService;
import com.wooribound.domain.jobposting.dto.JobPostingDTO;
import com.wooribound.domain.jobposting.dto.JobPostingDetailDTO;
import com.wooribound.domain.userapply.Service.UserApplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
public class WbUserJobPostingFacade {

    private final UserApplyService userApplyService;
    private final WbUserJobPostingService wbUserJobPostingService;
   // private final AuthenticateUtil authenticateUtil;

    // 1. 공고 지원
    @Transactional
    public String applyForJob(UserApplyDTO userApplyDTO) {
        return userApplyService.createUserApply(userApplyDTO);
    }

    @Transactional(readOnly = true)
    public List<JobPostingDTO> getJobPostingsForNew(UserJobPostingReqDTO userJobPostingReqDTO) {
        return wbUserJobPostingService.getJobPostingsForNew(userJobPostingReqDTO);
    }

    @Transactional(readOnly = true)
    public List<JobPostingDTO> getJobPostingsForCareer(UserJobPostingReqDTO userJobPostingReqDTO) {
        return wbUserJobPostingService.getJobPostingsForCareer(userJobPostingReqDTO);
    }

    // 2. 공고 조회 - 전체, 회사명, 직무, 지역
    @Transactional(readOnly = true)
    public List<JobPostingDTO> getJobPostings(/*Authentication authentication,*/ UserJobPostingReqDTO userJobPostingReqDTO) {
//        String loginUser = authenticateUtil.CheckWbUserAuthAndGetUserId(authentication);
        return wbUserJobPostingService.getJobPostings(/*loginUser,*/ userJobPostingReqDTO);
    }

    // 3. 공고 상세 조회
    @Transactional(readOnly = true)
    public JobPostingDetailDTO getJobPostingDetail(Long postId) {
        return wbUserJobPostingService.getJobPostingDetail(postId);
    }

}
