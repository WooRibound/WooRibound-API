package com.wooribound.global.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OauthTestController {
  @GetMapping("/loginsuccess")
  public String loginSuccess() {
    return "loginsuccess.html"; // loginsuccess.html로 리턴
  }
}

