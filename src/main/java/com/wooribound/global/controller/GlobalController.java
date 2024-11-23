package com.wooribound.global.controller;

import com.wooribound.domain.job.JobDTO;
import com.wooribound.domain.job.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/global")
public class GlobalController {

    private final JobService jobService;

    @GetMapping("/jobs")
    @ResponseBody
    public List<JobDTO> showAllJobs() {
        return jobService.getAllJobs();
    }
}
