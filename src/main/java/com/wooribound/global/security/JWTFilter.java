package com.wooribound.global.security;

import com.wooribound.api.individual.dto.OAuthDTO;
import com.wooribound.domain.wbuser.WbUser;
import com.wooribound.domain.wbuser.WbUserRepository;
import com.wooribound.global.constant.YN;
import com.wooribound.global.exception.DeletedUserException;
import com.wooribound.global.exception.NoWbUserException;
import com.wooribound.global.security.userdetail.admin.AdminUserDetail;
import com.wooribound.global.security.userdetail.enterprise.EnterpriseUserDetail;
import com.wooribound.global.security.userdetail.wbuser.WbUserDetail;
import com.wooribound.global.util.JWTUtil;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.web.filter.OncePerRequestFilter;


@RequiredArgsConstructor
public class JWTFilter extends OncePerRequestFilter {

  // @RequiredArgsConstructor 통해 생성자 주입
  private final JWTUtil jwtUtil;
  private final RequestMatcher excludedUrls;

  public JWTFilter(JWTUtil jwtUtil) {
    this.jwtUtil = jwtUtil;

    // JWT 검증에서 제외할 URL 패턴들
    List<RequestMatcher> excludeMatchers = Arrays.asList(
        new AntPathRequestMatcher("/auth/admin/login"),
        new AntPathRequestMatcher("/auth/enterprise/login"),
        new AntPathRequestMatcher("/oauth2/**")
    );

    this.excludedUrls = new OrRequestMatcher(excludeMatchers);
  }

  @Override
  protected boolean shouldNotFilter(HttpServletRequest request) {
    // 제외할 URL 패턴과 일치하면 필터를 적용하지 않음
    return excludedUrls.matches(request);
  }
  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
      FilterChain filterChain) throws ServletException, IOException {
    String accessToken = request.getHeader("Authorization");
    System.out.println("Received Authorization header: " + accessToken);

    if (accessToken == null) {
      filterChain.doFilter(request, response);
      return;
    }

    String originToken = accessToken.replace("Bearer ", "");
    System.out.println("Token after trim: " + originToken);

    response.setContentType("application/json;charset=UTF-8");

    try {
      // 토큰 검증 (만료 체크 포함)
      if (!jwtUtil.validateToken(originToken)) {
        sendErrorResponse(response, HttpStatus.UNAUTHORIZED.value(), "INVALID_TOKEN");
        return;
      }
      System.out.println("토큰 유효성 검사 완료");
      // 토큰 타입 검증
      String category = jwtUtil.getCategory(originToken);
      if (!"access".equals(category)) {
        sendErrorResponse(response, HttpStatus.FORBIDDEN.value(), "INVALID_TOKEN_TYPE");
        return;
      }
      System.out.println("토큰 타입 검증 완료");
      // 인증 객체 생성
      String userName = jwtUtil.getUserName(originToken);
      String userId = jwtUtil.getUserId(originToken);
      String role = jwtUtil.getRole(originToken);

      Authentication authentication = getAuthentication(role, userId,
          userName);
      SecurityContextHolder.getContext().setAuthentication(authentication);

      filterChain.doFilter(request, response);

    } catch (ExpiredJwtException e) {
      // 토큰 만료
      System.out.println("필터 만료 응답 처리");
      sendErrorResponse(response, 419, "TOKEN_EXPIRED");
    } catch (DeletedUserException e) {
      throw e;
    } catch (Exception e) {
      // 기타 예외
      System.out.println("토큰 에러");
      e.printStackTrace();
      System.out.println("Exception during token processing: " + e.getMessage());
      sendErrorResponse(response, HttpStatus.UNAUTHORIZED.value(), "TOKEN_ERROR");
    }
  }

  private static Authentication getAuthentication(String role, String userId, String userName) {
    if (role.equals("ROLE_ENTERPRISE_USER")) {
      EnterpriseUserDetail enterpriseUserDetail = new EnterpriseUserDetail(
          userId,
          userName,
          null,
          List.of(() -> "ROLE_ENTERPRISE_USER")
      );
      return new UsernamePasswordAuthenticationToken(
          enterpriseUserDetail,
          null,
          enterpriseUserDetail.getAuthorities()
      );
    }

    if (role.equals("ROLE_SERVICE_ADMIN") || role.equals("ROLE_INFRA_ADMIN")) {
      AdminUserDetail adminUserDetail = new AdminUserDetail(
          userId,
          userName,
          null,
          List.of(() -> "ROLE_ADMIN_USER")
      );
      return new UsernamePasswordAuthenticationToken(
          adminUserDetail,
          null,
          adminUserDetail.getAuthorities()
      );
    }

    if (role.equals("ROLE_WbUser")) {
      OAuthDTO userDTO = new OAuthDTO();
      userDTO.setId(userId);
      userDTO.setName(userName);
      WbUserDetail wbUserDetail = new WbUserDetail(userDTO);
      return new UsernamePasswordAuthenticationToken(
          wbUserDetail,
          null,
          wbUserDetail.getAuthorities()
      );
    }

    throw new IllegalArgumentException("Invalid role: " + role);
  }

  private void sendErrorResponse(HttpServletResponse response, int status, String message) throws IOException {
    response.setStatus(status);
    response.setContentType("application/json;charset=UTF-8");
    String jsonResponse = String.format("{\"error\":\"%s\"}", message);
    PrintWriter writer = response.getWriter();
    writer.write(jsonResponse);
    writer.flush();
  }
}