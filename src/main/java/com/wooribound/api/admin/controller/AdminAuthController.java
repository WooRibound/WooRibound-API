package com.wooribound.api.admin.controller;

import com.wooribound.api.admin.dto.AdminApproveReqDTO;
import com.wooribound.api.admin.facade.AdminAuthFacade;
import com.wooribound.domain.admin.dto.AdminDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "서비스 관리자 권한 관련 API", description = "서비스 관리자 기능 중 가입/기업회원 가입 및 탈퇴 검증 입니다.")
@RestController
@RequestMapping("/api/admin/auth")
@RequiredArgsConstructor
public class AdminAuthController {

    private final AdminAuthFacade adminAuthFacade;

    @Operation(summary = "서비스 관리자 등록", description = "서비스 관리자 등록")
    @PostMapping("/join")
    public String join(@Validated @RequestBody AdminDTO adminDTO) {
        return adminAuthFacade.join(adminDTO);
    }

    @Operation(summary = "기업회원 회원가입 검증", description = "기업회원 회원가입 검증")
    @PostMapping("/join-approval")
    public String joinApprove(@RequestBody AdminApproveReqDTO adminApproveReqDTO) {
        return adminAuthFacade.joinApprove(adminApproveReqDTO);
    }

    @Operation(summary = "기업회원 회원탈퇴 검증", description = "기업회원 회원탈퇴 검증")
    @PostMapping("/delete-approval")
    public String deleteApprove(@RequestBody AdminApproveReqDTO adminApproveReqDTO) {
        return adminAuthFacade.deleteApprove(adminApproveReqDTO);
    }

    @Operation(summary = "로그 대시보드 조회", description = "인프라 로그 대시보드 조회")
    @GetMapping("/dashboard")
    public String getDashboard(Authentication authentication) {
        return adminAuthFacade.getDashboard(authentication);
    }
}
