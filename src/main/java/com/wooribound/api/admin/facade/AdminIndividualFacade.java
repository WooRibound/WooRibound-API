package com.wooribound.api.admin.facade;

import com.wooribound.api.admin.dto.AdminWbUserReqDTO;
import com.wooribound.domain.wbuser.AdminWbUserService;
import com.wooribound.domain.wbuser.dto.AdminIndividualDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class AdminIndividualFacade {

    private final AdminWbUserService adminWbUserService;

    public List<AdminIndividualDTO> getWbUsers(AdminWbUserReqDTO adminWbUserReqDTO) {
        return adminWbUserService.getWbUsers(adminWbUserReqDTO);
    }
}
