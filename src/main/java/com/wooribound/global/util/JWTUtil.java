package com.wooribound.global.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JWTUtil {

  private SecretKey secretKey;

  // application.yml에 있는 평문 secret key를 가져와 초기화하였다.
  // 여기서는 HS256으로 진행했다.
  public JWTUtil(@Value("${jwt.secret}") String secret) {
    this.secretKey = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8),
        Jwts.SIG.HS256.key().build().getAlgorithm());
  }

  // 사용자 Id 추출
  public String getUserId(String token) {
    return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload()
        .get("userId", String.class);
  }

  // 사용자명 추출
  public String getUserName(String token) {
    return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload()
        .get("userName", String.class);
  }

  // 권한 추출
  public String getRole(String token) {
    return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload()
        .get("role", String.class);
  }

  // token 만료 여부 확인
  public Boolean isExpired(String token) {
    return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload()
        .getExpiration().before(new Date());
  }

  // accessToken인지 refreshToken인지 확인
  public String getCategory(String token) {
    return Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token).getPayload()
        .get("category", String.class);
  }

  // JWT 발급
  public String createJwt(String category, String userId, String userName, String role,
      Long expiredMs) {
    return Jwts.builder()
        .claim("category", category)
        .claim("userId", userId)
        .claim("userName", userName)
        .claim("role", role)
        .issuedAt(new Date(System.currentTimeMillis()))
        .expiration(new Date(System.currentTimeMillis() + expiredMs))
        .signWith(secretKey)
        .compact();
  }

  public boolean validateToken(String token) {
    try {
      // 토큰 파싱 및 검증
      Jwts.parser()
          .verifyWith(secretKey)
          .build()
          .parseSignedClaims(token);
      return true;
    } catch (IllegalArgumentException e) {
      // 토큰이 null이거나 빈 문자열인 경우
      return false;
    } catch (ExpiredJwtException e) {
      // 토큰이 만료된 경우
      throw new ExpiredJwtException(e.getHeader(), e.getClaims(), "Token has expired");
    } catch (JwtException e) {
      // 그 외 JWT 관련 에러 (형식 오류, 서명 불일치 등)
      return false;
    }
  }
}