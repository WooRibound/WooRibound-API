package com.wooribound.domain.wbuser;

import com.wooribound.domain.wbuser.WbUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WbUserRepository extends JpaRepository<WbUser, String> {

  WbUser findByUserId(String userId);
}

