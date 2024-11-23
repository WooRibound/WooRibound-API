package com.wooribound.api.individual.controller;

import com.wooribound.api.individual.dto.WbUserJoinInfoResDTO;
import com.wooribound.api.individual.dto.WbUserJoinReqDTO;
import com.wooribound.api.individual.facade.WbUserAuthFacade;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/individualuser/auth/")
@RequiredArgsConstructor
public class WbUserAuthController {
  private final WbUserAuthFacade wbUserAuthFacade;
  @GetMapping("/join/info")
  public ResponseEntity<WbUserJoinInfoResDTO> joinInfo(Authentication authentication){
    return ResponseEntity.ok(wbUserAuthFacade.getJoinInfo(authentication));
  }

  @PostMapping("/join")
  public ResponseEntity<String> join(Authentication authentication, @RequestBody WbUserJoinReqDTO wbUserJoinReqDTO){
    return ResponseEntity.ok(wbUserAuthFacade.join(authentication, wbUserJoinReqDTO));
  }

  @PostMapping("/withdraw")
  public ResponseEntity<String> withdraw(Authentication authentication){
    return ResponseEntity.ok(wbUserAuthFacade.withdraw(authentication));
  }
}
