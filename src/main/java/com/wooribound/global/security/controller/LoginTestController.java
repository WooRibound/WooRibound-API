package com.wooribound.global.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/logintest")
public class LoginTestController {

  @GetMapping("/admin")
  public String adminLoginPage() {
    return "adminlogin"; // templates/adminlogin.html을 반환
  }

  @GetMapping("/enterprise")
  public String enterpriseLoginPage() {
    return "enterpriselogin"; // templates/enterpriselogin.html을 반환
  }
}

