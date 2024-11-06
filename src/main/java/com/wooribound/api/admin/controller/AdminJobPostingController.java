package com.wooribound.api.admin.controller;

import com.wooribound.api.admin.dto.AdminJobPostingReqDTO;
import com.wooribound.api.admin.facade.AdminJobPostingFacade;
import com.wooribound.domain.jobposting.DTO.JobPostingDTO;
import com.wooribound.domain.jobposting.DTO.JobPostingDetailDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/admin/jobposting")
public class AdminJobPostingController {
    private final AdminJobPostingFacade adminJobPostingFacade;

    @GetMapping
    public List<JobPostingDTO> getJobPostings(@ModelAttribute AdminJobPostingReqDTO adminJobPostingReqDTO) {
        return adminJobPostingFacade.getJobPostings(adminJobPostingReqDTO);
    }

    @GetMapping("/detail")
    public JobPostingDetailDTO getJobPostingDetail(@RequestParam Long postId) {
        return adminJobPostingFacade.getJobPostingDetail(postId);
    }

    @PostMapping("/delete")
    public String deleteJobPosting(@RequestParam Long postId) {
        return adminJobPostingFacade.deleteJobPosting(postId);
    }
}
