package com.wooribound.api.admin.controller;

import com.wooribound.api.admin.dto.AdminEnterpriseReqDTO;
import com.wooribound.api.admin.facade.AdminEnterpriseFacade;
import com.wooribound.domain.enterprise.dto.AdminEnterpriseDTO;
import com.wooribound.domain.enterprise.dto.AdminEnterpriseDetailDTO;
import com.wooribound.domain.enterprise.dto.AdminPendingEnterpriseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/join-request")
    public List<AdminPendingEnterpriseDTO> getPendingRegist(@RequestParam(required = false) String entName) {
        return adminEnterpriseFacade.getPendingRegist(entName);
    }

    @GetMapping("/delete-request")
    public List<AdminPendingEnterpriseDTO> getPendingDeletion(@RequestParam(required = false) String entName) {
        return adminEnterpriseFacade.getPendingDeletion(entName);
    }
}
