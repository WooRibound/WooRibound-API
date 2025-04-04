package com.wooribound.api.corporate.controller;

import com.wooribound.api.corporate.dto.EnterpriseJoinDTO;
import com.wooribound.api.corporate.facade.EnterpriseAuthFacade;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/corporate/auth")
public class EnterpriseAuthController {

    private final EnterpriseAuthFacade enterpriseAuthFacade;

    @PostMapping("/join")
    public ResponseEntity<String> join(@Valid @RequestBody EnterpriseJoinDTO enterpriseJoinDTO) {
        return ResponseEntity.ok(enterpriseAuthFacade.join(enterpriseJoinDTO));
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

