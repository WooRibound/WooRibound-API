package com.wooribound.domain.enterprise;

import com.wooribound.api.corporate.dto.*;
import com.wooribound.domain.enterprise.dto.EnterpriseInfoDTO;
import com.wooribound.domain.enterprise.dto.EnterpriseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EnterpriseService {
    // 0. 기업회원 생성
    void create(EnterpriseDTO enterpriseDTO);

    // 1. 기업회원 정보 조회
    EnterpriseInfoDTO getEnterpriseInfo(String entId);

    // 2. 기업회원 정보 수정
    String updateEnterpriseInfo(EnterpriseInfoReqDTO enterpriseInfoReqDTO);

    String duplicateIdCheck(String id);

    void withdraw(String id, String pw);
}
