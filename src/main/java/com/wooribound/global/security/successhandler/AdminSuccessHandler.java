package com.wooribound.global.security.successhandler;

import com.wooribound.global.security.userdetail.admin.AdminUserDetail;
import com.wooribound.global.security.userdetail.wbuser.WbUserDetail;
import com.wooribound.global.util.JWTUtil;
import com.wooribound.global.util.RedisUtil;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Duration;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AdminSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

  private final JWTUtil jwtUtil;
  private final RedisUtil redisUtil;
  @Override
  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
      throws IOException {
    System.out.println("관리자 사용자 로그인 success handler 입장");
    
    AdminUserDetail adminUserDetail = (AdminUserDetail) authentication.getPrincipal();

    // 토큰 생성시에 사용자Id와 이름, 권한이 필요하니 준비
    String userId = adminUserDetail.getId();
    String username = adminUserDetail.getUsername();
    // stream()을 사용해 권한 하나만 꺼내기
    String role = adminUserDetail.getAuthorities().stream()
        .findFirst()
        .map(GrantedAuthority::getAuthority)
        .orElse("ROLE_UNKNOWN"); // 권한이 없을 경우 기본값 설정 가능

    // accessToken과 refreshToken 생성
    String accessToken = jwtUtil.createJwt("access", userId, username, role, 60000L);
    String refreshToken = jwtUtil.createJwt("refresh", userId, username, role, 86400000L);

    // redis에 Refresh 토큰만 insert (key = username / value = refreshToken)
    redisUtil.setValues(userId, refreshToken, Duration.ofMillis(86400000L));

    // 응답
    response.setHeader("Access-Control-Expose-Headers", "access");
    response.setHeader("access", "Bearer " + accessToken);
    response.addCookie(createCookie("refresh", refreshToken));
  }

  private Cookie createCookie(String key, String value) {
    Cookie cookie = new Cookie(key, value);
    cookie.setMaxAge(24*60*60);     // 쿠키가 살아있을 시간
    /*cookie.setSecure();*/         // https에서만 동작할것인지 (로컬은 http 환경이라 안먹음)
    cookie.setPath("/");        // 쿠키가 전역에서 동작
    cookie.setHttpOnly(true);       // http에서만 쿠키가 동작할 수 있도록 (js와 같은곳에서 가져갈 수 없도록)

    return cookie;
  }
}
