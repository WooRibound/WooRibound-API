package com.wooribound.api.admin.controller;

import com.wooribound.api.admin.dto.AdminJoinApproveReqDTO;
import com.wooribound.api.admin.facade.AdminAuthFacade;
import com.wooribound.domain.admin.dto.AdminDTO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/admin/auth")
@RequiredArgsConstructor
public class AdminAuthController {

  private final AdminAuthFacade adminAuthFacade;

  @PostMapping("/join")
  public String Join(@Validated @RequestBody AdminDTO adminDTO){
    return adminAuthFacade.Join(adminDTO);
  }

  @PostMapping("/join-approval")
  public String JoinApproval(@RequestBody AdminJoinApproveReqDTO adminJoinApproveReqDTO){
    return adminAuthFacade.joinApprove(adminJoinApproveReqDTO);
  }
}
