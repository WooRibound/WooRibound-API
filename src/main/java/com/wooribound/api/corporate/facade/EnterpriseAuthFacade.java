package com.wooribound.api.corporate.facade;

import com.wooribound.api.corporate.dto.EnterpiseJoinDTO;
import com.wooribound.domain.enterprise.EnterpriseService;
import com.wooribound.domain.enterprise.dto.EnterpriseDTO;
import java.util.Date;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnterpriseAuthFacade {

  private final EnterpriseService enterpriseService;
  public String Join(EnterpiseJoinDTO enterpiseJoinDTO){
    enterpriseService.create(ConvertToOriginDTO(enterpiseJoinDTO));
    return "회원가입이 완료되었습니다.";
  }

  public EnterpriseDTO ConvertToOriginDTO(EnterpiseJoinDTO enterpiseJoinDTO){
    return EnterpriseDTO.builder()
        .entId(enterpiseJoinDTO.getEntId())
        .regNum(enterpiseJoinDTO.getRegNum())
        .entPwd(enterpiseJoinDTO.getEntPwd())
        .entName(enterpiseJoinDTO.getEntName())
        .entField(enterpiseJoinDTO.getEntField())
        .entSize(enterpiseJoinDTO.getEntSize())
        .ceoName(enterpiseJoinDTO.getCeoName())
        .revenue(enterpiseJoinDTO.getRevenue())
        .entAddr(enterpiseJoinDTO.getEntAddr())
        .createdAt(new Date())
        .build();
  }
}
