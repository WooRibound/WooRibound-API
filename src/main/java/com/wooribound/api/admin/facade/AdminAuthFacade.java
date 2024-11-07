package com.wooribound.api.admin.facade;

import com.wooribound.api.admin.dto.AdminApproveReqDTO;
import com.wooribound.domain.admin.dto.AdminDTO;
import com.wooribound.domain.admin.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminAuthFacade {

    private final AdminService adminService;


    public String join(AdminDTO adminDTO) {
        adminService.create(adminDTO);
        return "회원가입이 완료되었습니다.";
    }

    // 기업 회원가입 승인/반려
    public String joinApprove(AdminApproveReqDTO adminApproveReqDTO) {
        return adminService.joinApprove(adminApproveReqDTO);
    }

    // 기업 회원탈퇴 승인/반려
    public String deleteApprove(AdminApproveReqDTO adminApproveReqDTO) {
        return adminService.deleteApprove(adminApproveReqDTO);
    }
}

