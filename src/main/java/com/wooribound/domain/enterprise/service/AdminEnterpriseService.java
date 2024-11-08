package com.wooribound.domain.enterprise.service;

import com.wooribound.api.admin.dto.AdminEnterpriseReqDTO;
import com.wooribound.domain.enterprise.dto.AdminEnterpriseDTO;

import java.util.List;

public interface AdminEnterpriseService {
    List<AdminEnterpriseDTO> getEnterprises(AdminEnterpriseReqDTO adminEnterpriseReqDTO);
}
