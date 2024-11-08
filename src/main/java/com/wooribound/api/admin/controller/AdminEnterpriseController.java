package com.wooribound.api.admin.controller;

import com.wooribound.api.admin.dto.AdminEnterpriseReqDTO;
import com.wooribound.api.admin.dto.AdminWbUserReqDTO;
import com.wooribound.api.admin.facade.AdminEnterpriseFacade;
import com.wooribound.api.admin.facade.AdminIndividualFacade;
import com.wooribound.domain.enterprise.dto.AdminEnterpriseDTO;
import com.wooribound.domain.enterprise.dto.AdminEnterpriseDetailDTO;
import com.wooribound.domain.resume.dto.ResumeDetailDTO;
import com.wooribound.domain.wbuser.dto.AdminIndividualDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/admin/enterprise")
public class AdminEnterpriseController {

    private final AdminEnterpriseFacade adminEnterpriseFacade;

    @GetMapping
    public List<AdminEnterpriseDTO> getEnterprises(@ModelAttribute AdminEnterpriseReqDTO adminEnterpriseReqDTO) {
        return adminEnterpriseFacade.getEnterprises(adminEnterpriseReqDTO);
    }

    @GetMapping("/detail")
    public AdminEnterpriseDetailDTO getEnterpriseInfo(String entId) {
        return adminEnterpriseFacade.getEnterpriseInfo(entId);
    }

}
