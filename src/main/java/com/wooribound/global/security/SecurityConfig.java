package com.wooribound.global.security;

import com.wooribound.domain.wbuser.WbUserRepository;
import com.wooribound.global.exception.DeletedUserException;
import com.wooribound.global.security.successhandler.AdminSuccessHandler;
import com.wooribound.global.security.successhandler.EnterpriseSuccessHandler;
import com.wooribound.global.security.successhandler.WbUserSuccessHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wooribound.global.security.userdetail.admin.AdminUserDetailService;
import com.wooribound.global.security.userdetail.enterprise.EnterpriseUserDetailService;
import com.wooribound.global.security.userdetail.wbuser.WbUserDetailService;
import com.wooribound.global.util.JWTUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

  private final JWTUtil jwtUtil;
  private final WbUserSuccessHandler wbUserSuccessHandler;
  private final EnterpriseSuccessHandler enterpriseSuccessHandler;
  private final AdminSuccessHandler adminSuccessHandler;
  private final WbUserDetailService wbUserDetailService;
  private final AdminUserDetailService adminUserDetailService;
  private final EnterpriseUserDetailService enterpriseUserDetailService;
  @Value("${spring.data.targetIp}")
  private String TARGET_IP;
  @Value("${spring.data.targetPort}")
  private String TARGET_PORT;
  @Value("${spring.data.albDNS}")
  private String ALB_DNS;

  private String protocol;

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public DaoAuthenticationProvider adminAuthenticationProvider() {
    DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
    provider.setPasswordEncoder(passwordEncoder());
    provider.setUserDetailsService(adminUserDetailService);
    return provider;
  }

  @Bean
  public DaoAuthenticationProvider enterpriseAuthenticationProvider() {
    DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
    provider.setPasswordEncoder(passwordEncoder());
    provider.setUserDetailsService(enterpriseUserDetailService);
    return provider;
  }

  @Bean
  public AuthenticationManager authenticationManager() {
    return new ProviderManager(
        adminAuthenticationProvider(),
        enterpriseAuthenticationProvider()
    );
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    CustomAuthenticationFilter adminLoginFilter = new CustomAuthenticationFilter(
        authenticationManager(),
        "/api/auth/admin/login",
        adminSuccessHandler
    );

    CustomAuthenticationFilter enterpriseLoginFilter = new CustomAuthenticationFilter(
        authenticationManager(),
        "/api/auth/enterprise/login",
        enterpriseSuccessHandler
    );

    http
        .cors(corsCustomizer -> corsCustomizer.configurationSource(new CorsConfigurationSource() {
          @Override
          public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
            CorsConfiguration configuration = new CorsConfiguration();
            configuration.setAllowedOrigins(Arrays.asList(
                "http://"+TARGET_IP+":"+TARGET_PORT,
                "https://"+TARGET_IP,
                "https://"+ALB_DNS,
                "https://nid.naver.com",  // 네이버 로그인
                "https://openapi.naver.com"
            ));
            configuration.setAllowedMethods(Collections.singletonList("*"));
            configuration.setAllowCredentials(true);
            configuration.setAllowedHeaders(Collections.singletonList("*"));
            configuration.setExposedHeaders(Arrays.asList("access"));
            configuration.setMaxAge(3600L);
            return configuration;
          }
        }))
        .csrf(csrf -> csrf.disable())
        .addFilterAt(adminLoginFilter, UsernamePasswordAuthenticationFilter.class)
        .addFilterAt(enterpriseLoginFilter, UsernamePasswordAuthenticationFilter.class)
        .addFilterBefore(new JWTFilter(jwtUtil), UsernamePasswordAuthenticationFilter.class)
        .oauth2Login(oauth2 -> oauth2
            .successHandler(wbUserSuccessHandler)
            .failureHandler((request, response, exception) -> {
              if (exception instanceof OAuth2AuthenticationException) {
                Throwable authException = ((OAuth2AuthenticationException) exception).getCause();
                if (authException instanceof DeletedUserException) {
                  if (TARGET_PORT.equals("443")){
                    protocol = "https";
                  } else {
                    protocol = "http";
                  }
                  response.sendRedirect(protocol+"://"+TARGET_IP+":"+TARGET_PORT+"/deleted/user");
                  return;
                }
              }
              // 다른 예외의 경우 기본 처리
              throw exception;
            })
            .userInfoEndpoint(userInfoEndpointConfig -> userInfoEndpointConfig
                .userService(wbUserDetailService)))
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/api/auth/admin/login", "/api/auth/enterprise/login","/api/auth/refresh").permitAll()
            .requestMatchers("/auth/check", "/individualuser/auth/join").hasAnyAuthority(
                "ROLE_ENTERPRISE_USER",
                "ROLE_ADMIN_USER",
                "ROLE_WbUser"
            )
            .requestMatchers("/", "/**").permitAll())
        .sessionManagement(session -> session
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS));

    return http.build();
  }
}