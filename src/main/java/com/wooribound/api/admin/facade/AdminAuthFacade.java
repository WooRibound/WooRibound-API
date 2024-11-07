package com.wooribound.api.admin.facade;

import com.wooribound.api.admin.dto.AdminJoinApproveReqDTO;
import com.wooribound.domain.admin.dto.AdminDTO;
import com.wooribound.domain.admin.AdminService;
import com.wooribound.global.exception.NoJobPostingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminAuthFacade {

    private final AdminService adminService;

    public String Join(AdminDTO adminDTO) {
        adminService.create(adminDTO);
        return "회원가입이 완료되었습니다.";
    }

    public String joinApprove(AdminJoinApproveReqDTO adminJoinApproveReqDTO) {
        return adminService.joinApprove(adminJoinApproveReqDTO);
    }
}

