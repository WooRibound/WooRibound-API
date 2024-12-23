package com.wooribound.domain.enterprise;

import com.wooribound.api.corporate.dto.EnterpriseInfoReqDTO;
import com.wooribound.domain.enterprise.dto.EnterpriseDTO;
import com.wooribound.domain.enterprise.dto.EnterpriseInfoDTO;
import com.wooribound.global.constant.YNP;
import com.wooribound.global.exception.DuplicatedIdException;
import com.wooribound.global.exception.NoEnterpriseException;
import com.wooribound.global.exception.NotValidPasswordException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class EnterpriseServiceImpl implements EnterpriseService {

    private final EnterpriseRepository enterpriseRepository;
    private final PasswordEncoder passwordEncoder;

      // 0. 기업회원 생성
      @Override
      public void create(EnterpriseDTO enterpriseDTO) {
        Enterprise ent = Enterprise.builder()
            .entId(enterpriseDTO.getEntId())
            .entName(enterpriseDTO.getEntName())
            .entPwd(passwordEncoder.encode(enterpriseDTO.getEntPwd()))
            .entSize(enterpriseDTO.getEntSize())
            .entAddr1(enterpriseDTO.getEntAddr1())
            .entAddr2(enterpriseDTO.getEntAddr2())
            .revenue(enterpriseDTO.getRevenue())
            .regNum(enterpriseDTO.getRegNum())
            .entField(enterpriseDTO.getEntField())
            .ceoName(enterpriseDTO.getCeoName())
            .isDeleted(YNP.N)
            .build();
        enterpriseRepository.save(ent);
      }

      // 1. 기업회원 정보 조회
      @Override
      public EnterpriseInfoDTO getEnterpriseInfo(String entId) {
          Optional<Enterprise> enterprise = enterpriseRepository.findById(entId);

          if (enterprise.isPresent()) {
              Enterprise enterprise1 = enterprise.get();

              return EnterpriseInfoDTO.builder()
                      .entId(enterprise1.getEntId())
                      .regNum(enterprise1.getRegNum())
                      .entName(enterprise1.getEntName())
                      .ceoName(enterprise1.getCeoName())
                      .entField(enterprise1.getEntField())
                      .entSize(enterprise1.getEntSize())
                      .revenue(enterprise1.getRevenue())
                      .entAddr1(enterprise1.getEntAddr1())
                      .entAddr2(enterprise1.getEntAddr2())
                      .build();
          } else {
              log.error("해당 기업 회원이 존재하지 않습니다 - ID: {}", entId);
              throw new RuntimeException("해당 기업 회원 없음: " + entId);
          }

      }

      // 2. 기업회원 정보 수정
      @Override
      public String updateEnterpriseInfo(EnterpriseInfoReqDTO enterpriseInfoReqDTO) {
//          logger.info("기업회원 정보 수정 START, entId: {}", enterpriseInfoReqDTO.getEntName());
          String entId = enterpriseInfoReqDTO.getEntId();

          Enterprise enterprise = enterpriseRepository.findById(entId)
                  .orElseThrow(() -> new RuntimeException("해당 기업 회원이 존재하지 않습니다. ID: " + entId));

          if (enterpriseInfoReqDTO.getEntName() != null) {
              enterprise.setEntName(enterpriseInfoReqDTO.getEntName());
          }
          if (enterpriseInfoReqDTO.getEntField() != null) {
              enterprise.setEntField(enterpriseInfoReqDTO.getEntField());
          }
          if (enterpriseInfoReqDTO.getEntSize() != null) {
              enterprise.setEntSize(enterpriseInfoReqDTO.getEntSize());
          }
          if (enterpriseInfoReqDTO.getCeoName() != null) {
              enterprise.setCeoName(enterpriseInfoReqDTO.getCeoName());
          }
          if (enterpriseInfoReqDTO.getEntAddr1() != null) {
              enterprise.setEntAddr1(enterpriseInfoReqDTO.getEntAddr1());
          }
          if (enterpriseInfoReqDTO.getEntAddr2() != null) {
              enterprise.setEntAddr2(enterpriseInfoReqDTO.getEntAddr2());
          }

          enterpriseRepository.save(enterprise);

          return entId + " 기업회원 정보 수정 완료 : " +
                  "EntName : " + enterprise.getEntName() + ", " +
                  "EntField : " + enterprise.getEntField() + ", " +
                  "EntSize : " + enterprise.getEntSize() + ", " +
                  "CeoName : " + enterprise.getCeoName() + ", " +
                  "EntAddr1 : " + enterprise.getEntAddr1() + ", " +
                  "EntAddr2 : " + enterprise.getEntAddr2();
    }

  @Override
  public String duplicateIdCheck(String id) {
    Enterprise enterprise = enterpriseRepository.findById(id).orElse(null);
    if (enterprise == null) {
      return id+"는 사용 가능한 ID입니다.";
    } else {
      throw new DuplicatedIdException(id);
    }
  }

  @Override
  public void withdraw(String id, String pw) {
    System.out.println("들어온 비밀번호:" +pw);

    Optional<Enterprise> optionalEnterprise = enterpriseRepository.findByEntId(id);

      if (optionalEnterprise.isEmpty()) {
          throw new NoEnterpriseException("해당 기업 ID를 찾을 수 없습니다: " + id);
      }
      Enterprise enterprise = optionalEnterprise.get();
      if (!passwordEncoder.matches(pw, enterprise.getEntPwd())) {
      throw new NotValidPasswordException();
    }
    enterprise.setIsDeleted(YNP.P);
    enterpriseRepository.save(enterprise);
  }
}
