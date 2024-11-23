package com.wooribound.global.security.controller;

import com.wooribound.global.security.dto.RefreshTokenRequest;
import com.wooribound.global.security.userdetail.wbuser.WbUserDetail;
import com.wooribound.global.util.JWTUtil;
import com.wooribound.global.util.RedisUtil;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

  private final JWTUtil jwtUtil;
  private final RedisUtil redisUtil;

  @GetMapping("/check")
  public String checkLogin(Authentication authentication) {
    System.out.println("로그인 확인 메서드 호출");
    authentication.getAuthorities();

    // Authentication 객체가 null인지 확인
    if (authentication == null || !authentication.isAuthenticated()) {
      return "로그인 되어 있지 않습니다.";
    }

    Object data = authentication.getPrincipal();

    // principal이 null일 경우 확인
    if (data == null) {
      return "로그인 되어 있지 않습니다.";
    }

    return "로그인되어있습니다.";
  }


  @PostMapping("/refresh")
  public ResponseEntity<?> refreshAccessToken(HttpServletRequest request) {
    System.out.println("재발급 메서드 시작");

    // 1. 쿠키에서 리프레시 토큰 추출
    String refreshToken = null;
    if (request.getCookies() != null) {
      for (Cookie cookie : request.getCookies()) {
        if ("refresh".equals(cookie.getName())) {
          refreshToken = cookie.getValue();
          System.out.println(refreshToken);
          break;
        }
      }
    }

    // 리프레시 토큰이 없는 경우 처리
    if (refreshToken == null) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
          .body("REFRESH_TOKEN_NOT_FOUND");
    }

    try {
      // 2. 기본적인 토큰 형식 검증
      if (!jwtUtil.validateToken(refreshToken)) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
            .body("INVALID_TOKEN");
      }

      // 3. 토큰 타입 검증 (카테고리 확인)
      String category = jwtUtil.getCategory(refreshToken);
      if (!"refresh".equals(category)) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN)
            .body("INVALID_TOKEN_TYPE");
      }

      // 4. 사용자 ID 추출 및 Redis 검증
      String userId = jwtUtil.getUserId(refreshToken);
      String storedRefreshToken = redisUtil.getValues(userId);

      if (storedRefreshToken == null || !storedRefreshToken.equals(refreshToken)) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
            .body("INVALID_TOKEN");
      }

      // 5. 만료 여부 확인 (ExpiredJwtException 발생 가능)
      if (jwtUtil.isExpired(refreshToken)) {
        return ResponseEntity.status(419)
            .body("TOKEN_EXPIRED");
      }

      // 6. 새로운 액세스 토큰 발급
      String newAccessToken = jwtUtil.createJwt(
          "access",
          userId,
          jwtUtil.getUserName(refreshToken),
          jwtUtil.getRole(refreshToken),
          60000L
      );
      System.out.println("재발급 완료");
      return ResponseEntity.ok(newAccessToken);

    } catch (ExpiredJwtException e) {
      System.out.println("리프레시 토큰 만료");
      return ResponseEntity.status(419)
          .body("TOKEN_EXPIRED");
    } catch (Exception e) {
      System.out.println("리프레시 토큰이 유효하지 않음");
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
          .body("TOKEN_ERROR");
    }
  }
}

