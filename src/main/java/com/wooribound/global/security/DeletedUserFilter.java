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
  @Value("${targetIp}")
  private String targetIp;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {
    try {
      filterChain.doFilter(request, response);
    } catch (DeletedUserException e) {
      System.out.println("deleteduserfilter에서 잡아냄");
      response.sendRedirect("http://"+ targetIp +":8080/deleted/user");
    }
  }
}