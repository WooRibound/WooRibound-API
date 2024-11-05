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
@RequestMapping("/global")
public class GlobalController {

    private final JobService jobService;

    @Operation(summary = "직무 전체 조회 기능",
            description = "직무 목록 반환")

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved job list"),
            @ApiResponse(responseCode = "404", description = "No jobs found"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })

    @GetMapping("/jobs")
    @ResponseBody
    public List<JobDTO> showAllJobs() {
        return jobService.getAllJobs();
    }
}
