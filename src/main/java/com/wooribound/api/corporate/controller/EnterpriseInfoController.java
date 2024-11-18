package com.wooribound.api.corporate.controller;

import com.wooribound.api.corporate.dto.EmployeeDTO;
import com.wooribound.api.corporate.dto.EmploymentReqDTO;
import com.wooribound.api.corporate.dto.EnterpriseInfoReqDTO;
import com.wooribound.api.corporate.facade.EnterpriseInfoFacade;
import com.wooribound.domain.enterprise.dto.EnterpriseInfoDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "기업 회원 정보 관련 API", description = "기업회원 서비스 중 기업정보 관리/직원 관리 입니다.")
@RequiredArgsConstructor
@RestController
@RequestMapping("/corporate/info")
public class EnterpriseInfoController {

    private final EnterpriseInfoFacade enterpriseInfoFacade;

    @Operation(summary = "기업 정보 조회", description = "기업 정보 조회")
    @GetMapping()
    public EnterpriseInfoDTO getEnterpriseInfo(Authentication authentication) {
        return enterpriseInfoFacade.getEnterpriseInfo(authentication);
    }

    @Operation(summary = "기업 정보 수정", description = "기업 정보 수정")
    @PostMapping("/update")
    public String updateEnterpriseInfo(@RequestBody EnterpriseInfoReqDTO enterpriseInfoReqDTO) {
        return enterpriseInfoFacade.updateEnterpriseInfo(enterpriseInfoReqDTO);
    }

    @Operation(summary = "고용 직원 목록 조회", description = "고용 직원 목록 조회")
    @GetMapping("/employee")
    public List<EmployeeDTO> getJobEmployees(Authentication authentication) {
        return enterpriseInfoFacade.getEmployees(authentication);
    }

    @Operation(summary = "고용 직원 평가", description = "고용 직원 평가")
    @PostMapping("/employee/rating")
    public String evaluateEmployee(@RequestBody EmploymentReqDTO employmentReqDTO) {
        return enterpriseInfoFacade.evaluateEmployee(employmentReqDTO);
    }

}
