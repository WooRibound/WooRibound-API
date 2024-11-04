package com.wooribound.domain.enterprise;

import com.wooribound.domain.enterprise.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnterpriseRepository extends JpaRepository<Enterprise, String> {

}
