package com.wooribound.domain.employment;

import com.wooribound.api.corporate.dto.EmployeeDTO;
import com.wooribound.api.corporate.dto.EmploymentReqDTO;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface EmploymentService {

    // 1. 고용 직원 목록 조회
    List<EmployeeDTO> getEmployees(String entId);

    // 2. 고용 직원 평가
    String evaluateEmployee(EmploymentReqDTO employmentReqDTO);

}
