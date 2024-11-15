package com.wooribound.api.corporate.controller;

import com.wooribound.api.corporate.dto.EmployeeDTO;
import com.wooribound.api.corporate.dto.EmploymentReqDTO;
import com.wooribound.api.corporate.dto.EnterpriseInfoReqDTO;
import com.wooribound.api.corporate.facade.EnterpriseInfoFacade;
import com.wooribound.domain.enterprise.dto.EnterpriseInfoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/corporate/info")
public class EnterpriseInfoController {

    private final EnterpriseInfoFacade enterpriseInfoFacade;

    // 1. 기업회원 정보 조회
    @GetMapping()
    public EnterpriseInfoDTO getEnterpriseInfo(Authentication authentication) {
        return enterpriseInfoFacade.getEnterpriseInfo(authentication);
    }

    // 2. 기업회원 정보 수정
    @PostMapping("/update")
    public String updateEnterpriseInfo(@RequestBody EnterpriseInfoReqDTO enterpriseInfoReqDTO) {
        return enterpriseInfoFacade.updateEnterpriseInfo(enterpriseInfoReqDTO);
    }

    // 3. 고용 직원 목록 조회
    @GetMapping("/employee")
    public List<EmployeeDTO> getJobEmployees(@RequestParam String entId) {
        return enterpriseInfoFacade.getEmployees(entId);
    }

    // 4. 고용 직원 평가
    @PostMapping("/employee/rating")
    public String evaluateEmployee(@RequestBody EmploymentReqDTO employmentReqDTO) {
        return enterpriseInfoFacade.evaluateEmployee(employmentReqDTO);
    }

}
