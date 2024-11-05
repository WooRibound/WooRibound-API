package com.wooribound.domain.admin;

import com.wooribound.domain.admin.dto.AdminDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService{
  private final AdminRepository adminRepository;
  private final PasswordEncoder passwordEncoder;


  @Override
  public void create(AdminDTO adminDTO){
    String encodedPW = passwordEncoder.encode(adminDTO.getAdminPw());
    adminDTO.setAdminPw(encodedPW);
    adminRepository.save(Admin.fromDTO(adminDTO));
  }

}
