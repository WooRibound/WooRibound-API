package com.wooribound.api.individual.controller;


import com.wooribound.domain.resume.ResumeService;
import com.wooribound.domain.resume.dto.ResumeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/individual/info/resume")
public class WbUserResumeController {

    private final ResumeService resumeService;

    // 이력서 조회
    @GetMapping
    public ResumeDTO getResume(@RequestParam String userId) {
        return resumeService.getResume(userId);
    }

     // 이력서 등록
    @PostMapping("/regist")
    public String registerResume(@RequestBody ResumeDTO resumeDTO) {
        return resumeService.registerResume(resumeDTO);
    }

    // 이력서 수정
    @PostMapping("/update")
    public String updateResume(@RequestBody ResumeDTO resumeDTO) {
        return resumeService.updateResume(resumeDTO);
    }
}
