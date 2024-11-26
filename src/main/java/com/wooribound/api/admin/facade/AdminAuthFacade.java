package com.wooribound.api.admin.facade;

import com.wooribound.api.admin.dto.AdminApproveReqDTO;
import com.wooribound.domain.admin.dto.AdminDTO;
import com.wooribound.domain.admin.AdminService;
import com.wooribound.global.util.AuthenticateUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AdminAuthFacade {

    private final AdminService adminService;
    private final AuthenticateUtil authenticateUtil;

    @Transactional
    public String join(AdminDTO adminDTO) {
        adminService.create(adminDTO);
        return "회원가입이 완료되었습니다.";
    }

    // 기업 회원가입 승인/반려
    @Transactional
    public String joinApprove(AdminApproveReqDTO adminApproveReqDTO) {
        return adminService.joinApprove(adminApproveReqDTO);
    }

    // 기업 회원탈퇴 승인/반려
    @Transactional
    public String deleteApprove(AdminApproveReqDTO adminApproveReqDTO) {
        return adminService.deleteApprove(adminApproveReqDTO);
    }

    public String getDashboard(Authentication authentication) {
        String adminId = authenticateUtil.CheckAdminAuthAndGetUserId(authentication);
        return adminService.getDashboard(adminId);
    }
}