package com.wooribound.domain.employment;

import com.wooribound.api.corporate.dto.EmployeeDTO;
import com.wooribound.api.corporate.dto.EmploymentReqDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class EmploymentServiceImpl implements EmploymentService{

    private final EmploymentRepository employmentRepository;

    // 1. 고용 직원 목록 조회
    @Override
    public List<EmployeeDTO> getEmployees(String entId) {
        return employmentRepository.findByEnterprise_EntIdOrderByHireDateAsc(entId).stream()
                .map(employment -> EmployeeDTO.builder()
                        .empId(employment.getEmpId())
                        .hireDate(employment.getHireDate())
                        .userName(employment.getWbUser().getName())
                        .jobName(employment.getJob().getJobName())
                        .empRecomm(employment.getEmpRecomm())
                        .build())
                .collect(Collectors.toList());
    }

    // 2. 고용 직원 평가
    @Override
    public String evaluateEmployee(EmploymentReqDTO employmentReqDTO) {
        log.info("고용 직원 평가 시작, empId: {}, empRecomm: {}", employmentReqDTO.getEmpId(), employmentReqDTO.getEmpRecomm());
        Long empId = employmentReqDTO.getEmpId();
        Optional<Employment> employee = employmentRepository.findById(empId);
        if (employee.isEmpty()) {
            throw new RuntimeException("해당 직원이 존재하지 않습니다: " + employmentReqDTO.getEmpId());
        }

        Employment user = employee.get();
        user.setEmpRecomm(employmentReqDTO.getEmpRecomm());
        employmentRepository.save(user);
        return "고용직원 평가가 완료되었습니다. : "+empId;
    }
}
