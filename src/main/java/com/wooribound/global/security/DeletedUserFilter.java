package com.wooribound.global.security;

import com.wooribound.global.exception.DeletedUserException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class DeletedUserFilter extends OncePerRequestFilter {
  @Value("${spring.data.targetIp}")
  private String TARGET_IP;
  @Value("${spring.data.targetPort}")
  private String TARGET_PORT;

  private String protocol;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {
    try {
      filterChain.doFilter(request, response);
    } catch (DeletedUserException e) {
      System.out.println("deleteduserfilter에서 잡아냄");
      if (TARGET_PORT.equals("443")) {
        protocol = "https";
      } else {
        protocol = "http";
      }
      response.sendRedirect(protocol+"://"+ TARGET_IP +":"+TARGET_PORT+"/deleted/user");
    }
  }
}