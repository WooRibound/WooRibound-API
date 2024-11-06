package com.wooribound.domain.wbuser;

import com.wooribound.domain.wbuser.WbUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WbUserRepository extends JpaRepository<WbUser, String> {

  Optional<WbUser> findByUserId(String userId);
}

