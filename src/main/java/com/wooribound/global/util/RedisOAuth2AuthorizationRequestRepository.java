package com.wooribound.global.util;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.oauth2.client.web.AuthorizationRequestRepository;
import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationRequest;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
public class RedisOAuth2AuthorizationRequestRepository implements AuthorizationRequestRepository<OAuth2AuthorizationRequest> {

    private final RedisTemplate<String, OAuth2AuthorizationRequest> oauth2AuthorizationRequestRedisTemplate;
    private static final String OAUTH2_AUTHORIZATION_REQUEST_PREFIX = "oauth2_auth_request:";
    private static final int TIMEOUT = 10 * 60;

    @Override
    public void saveAuthorizationRequest(
            OAuth2AuthorizationRequest authorizationRequest,
            HttpServletRequest request,
            HttpServletResponse response) {
        if (authorizationRequest == null) {
            removeAuthorizationRequest(request, response);
            return;
        }

        String state = authorizationRequest.getState();
        oauth2AuthorizationRequestRedisTemplate.opsForValue().set(
                OAUTH2_AUTHORIZATION_REQUEST_PREFIX + state,
                authorizationRequest,
                TIMEOUT,
                TimeUnit.SECONDS
        );
    }

    @Override
    public OAuth2AuthorizationRequest loadAuthorizationRequest(HttpServletRequest request) {
        String state = request.getParameter("state");
        if (state == null) return null;

        return oauth2AuthorizationRequestRedisTemplate.opsForValue()
                .get(OAUTH2_AUTHORIZATION_REQUEST_PREFIX + state);
    }

    @Override
    public OAuth2AuthorizationRequest removeAuthorizationRequest(
            HttpServletRequest request,
            HttpServletResponse response) {
        String state = request.getParameter("state");
        if (state == null) return null;

        String key = OAUTH2_AUTHORIZATION_REQUEST_PREFIX + state;
        OAuth2AuthorizationRequest auth = oauth2AuthorizationRequestRedisTemplate.opsForValue().get(key);
        if (auth != null) {
            oauth2AuthorizationRequestRedisTemplate.delete(key);
        }
        return auth;
    }
}

