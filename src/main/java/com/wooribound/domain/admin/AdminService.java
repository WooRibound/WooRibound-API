package com.wooribound.domain.admin;

import com.wooribound.api.admin.dto.AdminApproveReqDTO;
import com.wooribound.domain.admin.dto.AdminDTO;
import org.springframework.stereotype.Service;

@Service
public interface AdminService {
    void create(AdminDTO adminDTO);

    String joinApprove(AdminApproveReqDTO adminApproveReqDTO);

    String deleteApprove(AdminApproveReqDTO adminApproveReqDTO);

    String getDashboard(String adminId);
}
