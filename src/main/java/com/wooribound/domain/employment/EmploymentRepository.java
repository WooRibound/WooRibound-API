package com.wooribound.domain.employment;

import com.wooribound.api.corporate.dto.EmployeeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmploymentRepository extends JpaRepository<Employment, Long> {

    List<Employment> findByEnterprise_EntId(String entId);
}
