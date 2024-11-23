package com.wooribound.api.admin.controller;

import com.wooribound.api.admin.dto.AdminJobPostingReqDTO;
import com.wooribound.api.admin.facade.AdminJobPostingFacade;
import com.wooribound.domain.jobposting.dto.JobPostingDTO;
import com.wooribound.domain.jobposting.dto.JobPostingDetailDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "채용공고 관리 관련 API", description = "서비스 관리자 기능 중 채용공고 관리 기능 입니다.")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/admin/jobposting")
public class AdminJobPostingController {
    private final AdminJobPostingFacade adminJobPostingFacade;

    @Operation(summary = "채용공고 목록 조회", description = "채용공고 목록 조회")
    @GetMapping
    public List<JobPostingDTO> getJobPostings(@ModelAttribute AdminJobPostingReqDTO adminJobPostingReqDTO) {
        return adminJobPostingFacade.getJobPostings(adminJobPostingReqDTO);
    }

    @Operation(summary = "채용공고 상세 정보 조회", description = "채용공고 상세 정보 조회")
    @GetMapping("/detail")
    public JobPostingDetailDTO getJobPostingDetail(@RequestParam Long postId) {
        return adminJobPostingFacade.getJobPostingDetail(postId);
    }

    @Operation(summary = "채용공고 삭제", description = "채용공고 삭제")
    @PostMapping("/delete")
    public String deleteJobPosting(@RequestParam Long postId) {
        return adminJobPostingFacade.deleteJobPosting(postId);
    }
}
