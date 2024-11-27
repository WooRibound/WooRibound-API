package com.wooribound.global.security.successhandler;

import com.wooribound.global.constant.YN;
import com.wooribound.global.security.userdetail.wbuser.WbUserDetail;
import com.wooribound.global.util.JWTUtil;
import com.wooribound.global.util.RedisUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Cookie;
import java.io.IOException;
import java.time.Duration;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@RequiredArgsConstructor
public class WbUserSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
  private final JWTUtil jwtUtil;
  private final RedisUtil redisUtil;
  @Value("${spring.data.targetIp}")
  private String TARGET_IP;
  @Value("${spring.data.targetPort}")
  private String TARGET_PORT;

  private String protocol;





  @Override
  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
      throws IOException {
    WbUserDetail wbUserDetail = (WbUserDetail) authentication.getPrincipal();

    // 토큰 생성시에 사용자Id와 이름, 권한이 필요하니 준비
    String userId = wbUserDetail.getId();
    String username = wbUserDetail.getName();
    // stream()을 사용해 권한 하나만 꺼내기
    String role = wbUserDetail.getAuthorities().stream()
        .findFirst()
        .map(GrantedAuthority::getAuthority)
        .orElse("ROLE_UNKNOWN"); // 권한이 없을 경우 기본값 설정 가능

    // accessToken과 refreshToken 생성
    String accessToken = jwtUtil.createJwt("access", userId, username, role, 86400000L); //개발 편의성을 위해 하루로 해놨음 나중에 1분인 60000L 로 수정
    String refreshToken = jwtUtil.createJwt("refresh", userId, username, role, 86400000L);

    // redis에 insert (key = username / value = refreshToken)
    redisUtil.setValues(userId, refreshToken, Duration.ofMillis(86400000L));

    if (TARGET_PORT.equals("443")){
      protocol = "https";
    } else {
      protocol = "http";
    }

    // 응답
    // 응답
    String redirectUrl_oldUser = UriComponentsBuilder
        .fromUriString(protocol+"://"+TARGET_IP+":"+TARGET_PORT)
        .fragment("accessToken=" + accessToken)
        .build()
        .toUriString();

    String redirectUrl_newUser = UriComponentsBuilder
        .fromUriString(protocol+"://"+TARGET_IP+":"+TARGET_PORT+"/individual-user/register")
        .fragment("accessToken=" + accessToken)  // fragment로 accesstoken 전송
        .build()
        .toUriString();


    response.addCookie(createCookie("refresh", refreshToken));
    if (wbUserDetail.getFirstLogin() == YN.Y) {
      response.sendRedirect(redirectUrl_newUser);
    } else {
      response.sendRedirect(redirectUrl_oldUser);
    }

  }

  private Cookie createCookie(String key, String value) {
    Cookie cookie = new Cookie(key, value);
    cookie.setMaxAge(24*60*60);     // 쿠키가 살아있을 시간
    /*cookie.setSecure();*/         // https에서만 동작할것인지 (로컬은 http 환경이라 안먹음)
    cookie.setPath("/");       // 쿠키가 전역에서 동작
    cookie.setHttpOnly(true);       // http에서만 쿠키가 동작할 수 있도록 (js와 같은곳에서 가져갈 수 없도록)

    return cookie;
  }

}