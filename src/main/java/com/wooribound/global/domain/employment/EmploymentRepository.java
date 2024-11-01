package com.wooribound.global.domain.employment;

import com.wooribound.global.domain.education.Education;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmploymentRepository extends JpaRepository<Education, Long> {

}
