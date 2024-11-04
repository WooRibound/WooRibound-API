package com.wooribound.global.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OauthTestController {
  @GetMapping("/oauth")
  public String home() {
    return "oauth.html"; // oauth.html로 리턴
  }
}

