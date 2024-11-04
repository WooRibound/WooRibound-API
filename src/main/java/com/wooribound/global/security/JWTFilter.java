package com.wooribound.global.security;

import com.wooribound.api.individual.dto.OAuthDTO;
import com.wooribound.global.util.JWTUtil;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

@RequiredArgsConstructor
public class JWTFilter extends OncePerRequestFilter {

  // @RequiredArgsConstructor 통해 생성자 주입
  private final JWTUtil jwtUtil;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
      FilterChain filterChain) throws ServletException, IOException {
    // 요청 헤더에 있는 access라는 값을 가져오자 이게 accessToken이다.
    String accessToken = request.getHeader("access");

    // 요청헤더에 access가 없는 경우
    if (accessToken == null) {
      filterChain.doFilter(request, response);
      return;
    }

    // Bearer 제거 <- oAuth2를 이용했다고 명시적으로 붙여주는 타입인데 JWT를 검증하거나 정보를 추출 시 제거해줘야한다.
    String originToken = accessToken.substring(7);

    // 유효한지 확인 후 클라이언트로 상태 코드 응답
    try {
      if (jwtUtil.isExpired(originToken)) {
        PrintWriter writer = response.getWriter();
        writer.println("access token expired");

        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        return;
      }
    } catch (ExpiredJwtException e) {
      PrintWriter writer = response.getWriter();
      writer.println("access token expired");

      response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
      return;
    }

    // accessToken인지 refreshToken인지 확인
    String category = jwtUtil.getCategory(originToken);

    // JWTFilter는 요청에 대해 accessToken만 취급하므로 access인지 확인
    if (!"access".equals(category)) {
      PrintWriter writer = response.getWriter();
      writer.println("invalid access token");

      response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
      return;
    }

    // 사용자명과 권한을 accessToken에서 추출
    String userName = jwtUtil.getUserName(originToken);
    String userId = jwtUtil.getUserId(originToken);
    //String role = jwtUtil.getRole(originToken);

    OAuthDTO userDTO = new OAuthDTO();
    userDTO.setId(userId);
    userDTO.setName(userName);

    WbUserDetail wbUserDetail = new WbUserDetail(userDTO);

    Authentication authentication = new UsernamePasswordAuthenticationToken(
        wbUserDetail, null, wbUserDetail.getAuthorities());

    SecurityContextHolder.getContext().setAuthentication(authentication);

    filterChain.doFilter(request, response);
  }
}