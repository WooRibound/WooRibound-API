package com.wooribound.api.admin.facade;

import com.wooribound.api.admin.dto.AdminEnterpriseReqDTO;
import com.wooribound.domain.enterprise.dto.AdminEnterpriseDTO;
import com.wooribound.domain.enterprise.dto.AdminEnterpriseDetailDTO;
import com.wooribound.domain.enterprise.dto.AdminPendingEnterpriseDTO;
import com.wooribound.domain.enterprise.service.AdminEnterpriseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Component
public class AdminEnterpriseFacade {

    private final AdminEnterpriseService adminEnterpriseService;

    @Transactional(readOnly = true)
    public List<AdminEnterpriseDTO> getEnterprises(AdminEnterpriseReqDTO adminEnterpriseReqDTO) {
        return adminEnterpriseService.getEnterprises(adminEnterpriseReqDTO);
    }

    @Transactional(readOnly = true)
    public AdminEnterpriseDetailDTO getEnterpriseInfo(String entId) {
        return adminEnterpriseService.getEnterpriseInfo(entId);
    }

    @Transactional(readOnly = true)
    public  List<AdminPendingEnterpriseDTO> getPendingEnterpriseRegist(String entName) {
        return adminEnterpriseService.getPendingEnterpriseRegist(entName);
    }
}