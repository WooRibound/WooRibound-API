package com.wooribound.domain.admin;

import com.wooribound.domain.admin.dto.AdminDTO;
import org.springframework.stereotype.Service;

@Service
public interface AdminService {
  public void create(AdminDTO adminDTO);
}
