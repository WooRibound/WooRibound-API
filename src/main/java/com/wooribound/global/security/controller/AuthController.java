package com.wooribound.global.security.controller;

import com.wooribound.global.security.dto.RefreshTokenRequest;
import com.wooribound.global.security.userdetail.wbuser.WbUserDetail;
import com.wooribound.global.util.JWTUtil;
import com.wooribound.global.util.RedisUtil;
import io.jsonwebtoken.ExpiredJwtException;
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
@RequestMapping("/auth")
public class AuthController {

  private final JWTUtil jwtUtil;
  private final RedisUtil redisUtil;
  @GetMapping("/check")
  public String checkLogin(Authentication authentication) {
    System.out.println("메서드 호출");

    // Authentication 객체가 null인지 확인
    if (authentication == null || !authentication.isAuthenticated()) {
      return "로그인 되어 있지 않습니다.";
    }

    Object data = authentication.getPrincipal();

    // principal이 null일 경우 확인
    if (data == null) {
      return "로그인 되어 있지 않습니다.";
    }

    // WbUserDetail로 캐스팅
    WbUserDetail userDetail = (WbUserDetail) data;

    return userDetail.getName();
  }



  @PostMapping("/refresh")
  public ResponseEntity<?> refreshAccessToken(@RequestBody RefreshTokenRequest refreshTokenRequest) {
    String refreshToken = refreshTokenRequest.getRefreshToken();
    // JWT 유효성 검증
    try {
      if (!jwtUtil.validateToken(refreshToken)) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
            .body("Invalid refresh token");
      }

      // Refresh Token인지 검증
      String category = jwtUtil.getCategory(refreshToken);
      if (!"refresh".equals(category)) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
            .body("Invalid token type");
      }
    } catch (ExpiredJwtException e) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
          .body("Refresh token has expired");
    }
    // JWT에서 사용자 ID 추출
    String userId;
    try {
      // JWT에서 사용자 ID 추출 (유효성 검사 포함)
      userId = jwtUtil.getUserId(refreshToken); // JWTUtil 클래스에 이 메소드가 있어야 함
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid refresh token");
    }

    // Redis에서 리프레시 토큰 조회
    String storedRefreshToken = redisUtil.getValues(userId);

    // 저장된 리프레시 토큰과 요청한 리프레시 토큰 비교
    if (storedRefreshToken != null && storedRefreshToken.equals(refreshToken)) {
      // 토큰이 유효한 경우 새로운 액세스 토큰 생성
      String newAccessToken = jwtUtil.createJwt("access", userId, jwtUtil.getUserName(refreshToken), jwtUtil.getRole(refreshToken), 60000L);
      return ResponseEntity.ok(newAccessToken);
    } else {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid refresh token");
    }
  }
}
