package com.wooribound.domain.admin;

import com.wooribound.api.admin.dto.AdminJoinApproveReqDTO;
import com.wooribound.domain.admin.dto.AdminDTO;
import org.springframework.stereotype.Service;

@Service
public interface AdminService {
    void create(AdminDTO adminDTO);

    String joinApprove(AdminJoinApproveReqDTO adminJoinApproveReqDTO);
}
