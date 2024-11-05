package com.wooribound.global.security.userdetail.admin;

import com.wooribound.domain.admin.Admin;
import com.wooribound.domain.admin.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AdminUserDetailService implements UserDetailsService {

  @Autowired
  private final AdminRepository adminUserRepository;

  @Override
  public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
    Admin adminUser = adminUserRepository.findById(userId)
        .orElseThrow(() -> new UsernameNotFoundException("User not found: " + userId));

    return new AdminUserDetail(adminUser.getAdminId(), adminUser.getAdminName(), adminUser.getAdminPw(), List.of(() -> adminUser.getAdminType().toString()));
  }
}

