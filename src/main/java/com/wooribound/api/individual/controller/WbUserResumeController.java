package com.wooribound.api.individual.controller;


import com.wooribound.domain.resume.ResumeService;
import com.wooribound.domain.resume.dto.ResumeDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Tag(name = "이력서 API", description = "개인회원 서비스 중 이력서 입니다.")
@RestController
@RequiredArgsConstructor
@RequestMapping("/individual/info/resume")
public class WbUserResumeController {

    private final ResumeService resumeService;

    @Operation(summary = "이력서 조회", description = "이력서 조회")
    @GetMapping
    public ResponseEntity getResume(Authentication authentication) {

        return ResponseEntity.ok().body(resumeService.getResume(authentication));
    }

    @Operation(summary = "이력서 등록", description = "이력서 등록")
    @PostMapping(value = "/regist", consumes = {"multipart/form-data"})
    public ResponseEntity registerResume(Authentication authentication,
                                         @RequestParam("userImg") MultipartFile userImg,
                                         @RequestParam("resumeEmail") String resumeEmail,
                                         @RequestParam("userIntro") String userIntro) throws IOException {
        return ResponseEntity.ok().body(resumeService.registerResume(authentication, userImg, resumeEmail, userIntro));
    }

    @Operation(summary = "이력서 수정", description = "이력서 수정")
    @PostMapping(value = "/update", consumes = {"multipart/form-data"})
    public ResponseEntity updateResume(Authentication authentication,
                                       @RequestParam(value = "userImg", required = false) MultipartFile userImg,
                                       @RequestParam("resumeEmail") String resumeEmail,
                                       @RequestParam("userIntro") String userIntro) throws IOException {
        return ResponseEntity.ok().body(resumeService.updateResume(authentication, userImg, resumeEmail, userIntro));
    }
}
