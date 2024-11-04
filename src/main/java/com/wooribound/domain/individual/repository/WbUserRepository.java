package com.wooribound.domain.individual.repository;

import com.wooribound.domain.individual.entity.WbUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WbUserRepository extends JpaRepository<WbUser, String> {

  WbUser findByUserId(String userId);
}

