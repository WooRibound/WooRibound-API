package com.wooribound.domain.employment;

import com.wooribound.domain.education.Education;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmploymentRepository extends JpaRepository<Education, Long> {

}
