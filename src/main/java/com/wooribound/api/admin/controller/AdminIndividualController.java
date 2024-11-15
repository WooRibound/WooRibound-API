package com.wooribound.api.admin.controller;

import com.wooribound.api.admin.dto.AdminWbUserReqDTO;
import com.wooribound.api.admin.facade.AdminIndividualFacade;
import com.wooribound.domain.resume.dto.ResumeDetailDTO;
import com.wooribound.domain.wbuser.dto.AdminIndividualDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "개인회원 관리 관련 API", description = "서비스 관리자 기능 중 개인회원 정보 조회 기능 입니다.")
@RequiredArgsConstructor
@RestController
@RequestMapping("/admin/individual")
public class AdminIndividualController {

    private final AdminIndividualFacade adminIndividualFacade;

    @Operation(summary = "개인회원 목록 조회", description = "개인회원 목록 조회")
    @GetMapping
    public List<AdminIndividualDTO> getWbUsers(@ModelAttribute AdminWbUserReqDTO adminWbUserReqDTO) {
        return adminIndividualFacade.getWbUsers(adminWbUserReqDTO);
    }

    @Operation(summary = "개인회원 상세 정보 조회", description = "개인회원 상세 정보 조회")
    @GetMapping("/detail")
    public ResumeDetailDTO getWbUserResume(@RequestParam String userId) {
        return adminIndividualFacade.getWbUserResume(userId);
    }
}
