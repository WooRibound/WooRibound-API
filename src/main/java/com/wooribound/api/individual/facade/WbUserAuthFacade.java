package com.wooribound.api.individual.facade;

import com.wooribound.api.individual.dto.WbUserDTO;
import com.wooribound.api.individual.dto.WbUserJoinInfoResponseDTO;
import com.wooribound.domain.wbuser.WbUserService;
import com.wooribound.global.util.AuthenticateUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WbUserAuthFacade {
  private final WbUserService wbUserService;
  private final AuthenticateUtil authenticateUtil;


  public WbUserJoinInfoResponseDTO getJoinInfo(Authentication authentication){
    String userId = authenticateUtil.CheckWbUserAuthAndGetUserId(authentication);
    WbUserDTO wbUserDTO = wbUserService.getOneUserInfo(userId);

    return WbUserJoinInfoResponseDTO.builder()
        .name(wbUserDTO.getName())
        .email(wbUserDTO.getEmail())
        .phone(wbUserDTO.getPhone())
        .gender(wbUserDTO.getGender())
        .birth(wbUserDTO.getBirth())
        .build();
  }
}
