package com.wooribound.domain.enterprise;

import com.wooribound.domain.enterprise.dto.EnterpriseDTO;
import com.wooribound.global.constant.YN;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnterpriseServiceImpl implements EnterpriseService{

  private final EnterpriseRepository enterpriseRepository;
  private final PasswordEncoder passwordEncoder;

  // 새로 생성할 때의 함수
  @Override
  public void create(EnterpriseDTO enterpriseDTO) {

    Enterprise ent = Enterprise.builder()
        .entId(enterpriseDTO.getEntId())
        .entName(enterpriseDTO.getEntName())
        .entPwd(passwordEncoder.encode(enterpriseDTO.getEntPwd()))
        .entSize(enterpriseDTO.getEntSize())
        .entAddr(enterpriseDTO.getEntAddr())
        .revenue(enterpriseDTO.getRevenue())
        .regNum(enterpriseDTO.getRegNum())
        .entField(enterpriseDTO.getEntField())
        .ceoName(enterpriseDTO.getCeoName())
        .createdAt(enterpriseDTO.getCreatedAt())
        .isDeleted(YN.N)
        .build();
    enterpriseRepository.save(ent);
  }

  // 업데이트 시의 함수는 달라야함.
}
