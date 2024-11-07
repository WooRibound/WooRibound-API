package com.wooribound.api.individual.controller;

import com.wooribound.api.individual.dto.WbUserJoinInfoResponseDTO;
import com.wooribound.api.individual.facade.WbUserAuthFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/individualuser/auth/")
@RequiredArgsConstructor
public class WbUserAuthController {
  private final WbUserAuthFacade wbUserAuthFacade;
  @GetMapping("/join/info")
  public ResponseEntity<WbUserJoinInfoResponseDTO> JoinInfo(Authentication authentication){
    return ResponseEntity.ok(wbUserAuthFacade.getJoinInfo(authentication));
  }

}
