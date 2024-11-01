package com.wooribound.domain.corporate.repository;

import com.wooribound.domain.corporate.entity.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnterpriseRepository extends JpaRepository<Enterprise, String> {

}
