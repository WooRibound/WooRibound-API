package com.wooribound.domain.enterprise;

import com.wooribound.domain.enterprise.dto.EnterpriseDTO;
import org.springframework.stereotype.Service;

@Service
public interface EnterpriseService {
  void create(EnterpriseDTO enterpriseDTO);
}
