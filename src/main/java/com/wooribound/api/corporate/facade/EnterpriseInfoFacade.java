package com.wooribound.api.corporate.facade;

import com.wooribound.api.corporate.dto.EmployeeDTO;
import com.wooribound.api.corporate.dto.EmploymentReqDTO;
import com.wooribound.api.corporate.dto.EnterpriseInfoReqDTO;
import com.wooribound.domain.employment.Employment;
import com.wooribound.domain.employment.EmploymentService;
import com.wooribound.domain.enterprise.EnterpriseService;
import com.wooribound.domain.enterprise.dto.EnterpriseInfoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Component
public class EnterpriseInfoFacade {
    private final EnterpriseService enterpriseService;
    private final EmploymentService employmentService;

    // 1. 기업회원 정보 조회
    @Transactional(readOnly = true)
    public EnterpriseInfoDTO getEnterpriseInfo(String entId) {
        return enterpriseService.getEnterpriseInfo(entId);
    }

    // 2. 기업회원 정보 수정
    @Transactional
    public String updateEnterpriseInfo(EnterpriseInfoReqDTO enterpriseInfoReqDTO ) {
        return enterpriseService.updateEnterpriseInfo(enterpriseInfoReqDTO);
    }

    // 3. 고용 직원 목록 조회
    @Transactional(readOnly = true)
    public List<EmployeeDTO> getEmployees(String entId) {
        return employmentService.getEmployees(entId);
    }

    // 4. 고용 직원 평가
    @Transactional
    public String evaluateEmployee(EmploymentReqDTO employmentReqDTO) {
        return employmentService.evaluateEmployee(employmentReqDTO);
    }
}
