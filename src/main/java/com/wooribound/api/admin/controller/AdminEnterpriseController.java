package com.wooribound.api.admin.controller;

import com.wooribound.api.admin.dto.AdminEnterpriseReqDTO;
import com.wooribound.api.admin.facade.AdminEnterpriseFacade;
import com.wooribound.domain.enterprise.dto.AdminEnterpriseDTO;
import com.wooribound.domain.enterprise.dto.AdminEnterpriseDetailDTO;
import com.wooribound.domain.enterprise.dto.AdminPendingEnterpriseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "기업회원 관리 관련 API", description = "서비스 관리자 기능 중 기업회원 정보 조회 기능 입니다.")
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/admin/enterprise")
public class AdminEnterpriseController {

    private final AdminEnterpriseFacade adminEnterpriseFacade;

    @Operation(summary = "기업회원 목록 조회", description = "기업회원 목록 조회")
    @GetMapping
    public List<AdminEnterpriseDTO> getEnterprises(@ModelAttribute AdminEnterpriseReqDTO adminEnterpriseReqDTO) {
        return adminEnterpriseFacade.getEnterprises(adminEnterpriseReqDTO);
    }

    @Operation(summary = "기업회원 상세 정보 조회", description = "기업회원 상세 정보 조회")
    @GetMapping("/detail")
    public AdminEnterpriseDetailDTO getEnterpriseInfo(@RequestParam String entId) {
        return adminEnterpriseFacade.getEnterpriseInfo(entId);
    }

    @Operation(summary = "회원가입 승인 대기 중인 기업 목록 조회", description = "회원가입 승인 대기 중인 기업 목록 조회")
    @GetMapping("/join-request")
    public List<AdminPendingEnterpriseDTO> getPendingRegist(@RequestParam(required = false) String entName) {
        return adminEnterpriseFacade.getPendingRegist(entName);
    }

    @Operation(summary = "회원탈퇴 승인 대기 중인 기업 목록 조회", description = "회원탈퇴 승인 대기 중인 기업 목록 조회")
    @GetMapping("/delete-request")
    public List<AdminPendingEnterpriseDTO> getPendingDeletion(@RequestParam(required = false) String entName) {
        return adminEnterpriseFacade.getPendingDeletion(entName);
    }
}
