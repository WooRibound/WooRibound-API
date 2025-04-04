package com.wooribound.api.corporate.facade;

import com.wooribound.api.corporate.dto.EnterpriseJoinDTO;
import com.wooribound.domain.enterprise.EnterpriseService;
import com.wooribound.domain.enterprise.dto.EnterpriseDTO;
import com.wooribound.global.exception.NotValidPasswordException;
import com.wooribound.global.exception.WithdrawException;
import com.wooribound.global.util.AuthenticateUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EnterpriseAuthFacade {

  private final EnterpriseService enterpriseService;
  private final AuthenticateUtil authenticateUtil;
  @Transactional
  public String join(EnterpriseJoinDTO enterpriseJoinDTO){
    enterpriseService.create(ConvertToOriginDTO(enterpriseJoinDTO));
    return "회원가입이 완료되었습니다.";
  }

  private EnterpriseDTO ConvertToOriginDTO(EnterpriseJoinDTO enterpriseJoinDTO){
    return EnterpriseDTO.builder()
        .entId(enterpriseJoinDTO.getEntId())
        .regNum(enterpriseJoinDTO.getRegNum())
        .entPwd(enterpriseJoinDTO.getEntPwd())
        .entName(enterpriseJoinDTO.getEntName())
        .entField(enterpriseJoinDTO.getEntField())
        .enterpriseSizeType(enterpriseJoinDTO.getEnterpriseSizeType())
        .ceoName(enterpriseJoinDTO.getCeoName())
        .revenue(enterpriseJoinDTO.getRevenue())
        .entAddr1(enterpriseJoinDTO.getEntAddr1())
        .entAddr2(enterpriseJoinDTO.getEntAddr2())
        .build();
  }

  public String duplicateIdCheck(String id) {
    return enterpriseService.duplicateIdCheck(id);
  }

  public String withdraw(Authentication authentication, String pw) {
    try {
      String id = authenticateUtil.CheckEnterpriseAuthAndGetUserId(authentication);
      enterpriseService.withdraw(id, pw);
    } catch (NotValidPasswordException e) {
      e.printStackTrace();
      throw e;
    } catch (Exception e) {
      e.printStackTrace();
      throw new WithdrawException();
    }
    return "성공적으로 탈퇴되었습니다.";
  }

}
