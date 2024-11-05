package com.wooribound.global.security.userdetail.enterprise;

import com.wooribound.domain.enterprise.Enterprise;
import com.wooribound.domain.enterprise.EnterpriseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class EnterpriseUserDetailService implements UserDetailsService {

  @Autowired
  private final EnterpriseRepository enterpriseUserRepository;


  @Override
  public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
    Enterprise enterpriseUser = enterpriseUserRepository.findById(userId)
        .orElseThrow(() -> new UsernameNotFoundException("User not found: " + userId));

    return new EnterpriseUserDetail(enterpriseUser.getEntId(), enterpriseUser.getEntName(), enterpriseUser.getEntPwd(), List.of(() -> "ROLE_ENTERPRISE_USER"));
  }
}

