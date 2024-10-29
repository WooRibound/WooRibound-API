package com.wooribound.global.security;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {


  private static final String[] SWAGGER_URLS = {
      "/swagger-ui/**",
      "/"
  };

  private static final String[] AUTH_REQUIRED_URLS = {
      "/**"
  };

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http
        .csrf(AbstractHttpConfigurer::disable)
        .authorizeHttpRequests(
            auth -> {
              auth.requestMatchers(SWAGGER_URLS).permitAll();
              auth.requestMatchers(PathRequest.toStaticResources().atCommonLocations())
                  .permitAll();
              auth.requestMatchers(AUTH_REQUIRED_URLS) // TODO : 로그인 필요한 uri 다 집어넣기
                  .permitAll();
              auth.anyRequest().permitAll();
            }
        )
        .build();
  }

}
