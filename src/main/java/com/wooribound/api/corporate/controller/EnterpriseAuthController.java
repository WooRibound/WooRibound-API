package com.wooribound.api.corporate.controller;

import com.wooribound.api.corporate.dto.EnterpiseJoinDTO;
import com.wooribound.api.corporate.facade.EnterpriseAuthFacade;
import com.wooribound.domain.admin.dto.AdminDTO;
import com.wooribound.global.security.dto.IdPasswordRequest;
import com.wooribound.global.util.JWTUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/corporate/auth")
public class EnterpriseAuthController {

  private final EnterpriseAuthFacade enterpriseAuthFacade;

  @PostMapping("/join")
  public String join(@Validated @RequestBody EnterpiseJoinDTO enterpiseJoinDTO){
    return enterpriseAuthFacade.join(enterpiseJoinDTO);
  }
}
