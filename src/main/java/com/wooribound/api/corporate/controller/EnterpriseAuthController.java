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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/corporate/auth")
public class EnterpriseAuthController {

  private final EnterpriseAuthFacade enterpriseAuthFacade;

  @PostMapping("/join")
  public ResponseEntity<String> join(@Validated @RequestBody EnterpiseJoinDTO enterpiseJoinDTO){
    return ResponseEntity.ok(enterpriseAuthFacade.join(enterpiseJoinDTO));
  }


  @GetMapping("/duplicate/check")
  public ResponseEntity<String> duplicateIdCheck(@RequestParam String id) {
    return ResponseEntity.ok(enterpriseAuthFacade.duplicateIdCheck(id));
  }

  @PostMapping("/withdraw")
  public ResponseEntity<String> withdraw(Authentication authentication, @RequestBody String pw) {
    return ResponseEntity.ok(enterpriseAuthFacade.withdraw(authentication, pw));
  }
}

