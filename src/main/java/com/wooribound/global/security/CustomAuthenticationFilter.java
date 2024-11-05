package com.wooribound.global.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
  private final ObjectMapper objectMapper = new ObjectMapper();

  public CustomAuthenticationFilter(
      AuthenticationManager authenticationManager,
      String loginUrl,
      AuthenticationSuccessHandler successHandler) {

    super.setAuthenticationManager(authenticationManager);
    setFilterProcessesUrl(loginUrl);
    setAuthenticationSuccessHandler(successHandler);

    // 기본 실패 핸들러 설정
    setAuthenticationFailureHandler(new AuthenticationFailureHandler() {
      @Override
      public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
          AuthenticationException exception) throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json;charset=UTF-8");
        objectMapper.writeValue(response.getWriter(), Map.of(
            "error", "Authentication Failed",
            "message", exception.getMessage()
        ));
      }
    });
  }

  @Override
  public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
      throws AuthenticationException {
    try {
      String username;
      String password;

      // Content-Type 확인
      if (request.getContentType() != null && request.getContentType().contains("application/json")) {
        // JSON 처리
        Map<String, String> credentials = objectMapper.readValue(request.getInputStream(), Map.class);
        username = credentials.get("username");
        password = credentials.get("password");
      } else {
        // form-urlencoded 처리
        username = request.getParameter("username");
        password = request.getParameter("password");
      }

      System.out.println("Received username: " + username);
      System.out.println("Content-Type: " + request.getContentType());

      if (username == null) {
        username = "";
      }
      if (password == null) {
        password = "";
      }

      username = username.trim();

      // 인증 토큰 생성
      UsernamePasswordAuthenticationToken authRequest =
          new UsernamePasswordAuthenticationToken(username, password);

      // Allow subclasses to set the "details" property
      setDetails(request, authRequest);

      // 실제 인증 수행
      return this.getAuthenticationManager().authenticate(authRequest);

    } catch (IOException e) {
      System.err.println("Authentication error: " + e.getMessage());
      throw new IllegalArgumentException("Failed to parse authentication request body", e);
    }
  }

  @Override
  protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
      FilterChain chain, Authentication authResult) throws IOException, ServletException {
    // SuccessHandler에게 처리를 위임
    getSuccessHandler().onAuthenticationSuccess(request, response, authResult);
  }
}