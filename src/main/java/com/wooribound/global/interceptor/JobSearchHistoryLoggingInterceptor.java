package com.wooribound.global.interceptor;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wooribound.domain.wbuser.WbUserRepository;
import com.wooribound.global.filters.RequestWrapper;
import com.wooribound.global.interceptor.dto.JobSearchLogDTO;
import com.wooribound.global.interceptor.dto.WbUserLogDTO;
import com.wooribound.global.util.AuthenticateUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
public class JobSearchHistoryLoggingInterceptor implements HandlerInterceptor {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private final AuthenticateUtil authenticateUtil;
    private final WbUserRepository wbUserRepository;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if ("POST".equalsIgnoreCase(request.getMethod())) {
            MDC.put("traceId", String.format("[%s]", UUID.randomUUID()));

            Map<String, Object> jobSearchHistoryLog = new HashMap<>();
            RequestWrapper requestWrapper = new RequestWrapper(request);
            String requestBody = requestWrapper.getRequestBody();

            // API METHOD 담기
            jobSearchHistoryLog.put("method", request.getMethod());
            // URL 담기
            jobSearchHistoryLog.put("url", request.getRequestURI());
            // USER INFO 담기
            logUserInfo(jobSearchHistoryLog);
            // RequestBody 담기
            jobSearchHistoryLog.put("requestBody", parseToDto(requestBody));

            // 로그 출력
            try {
                String jsonLog = OBJECT_MAPPER.writeValueAsString(jobSearchHistoryLog);
                log.info("{}", jsonLog);
            } catch (JsonProcessingException e) {
                log.error("JSON 로깅 실패", e);
            }

        }

        return true; // 다음 단계로 요청 진행
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        MDC.clear();
    }

    private void logUserInfo(Map<String, Object> logData) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // 인증 정보가 없는 경우에도 진행되도록 처리
        if (authentication == null || !authentication.isAuthenticated() || "anonymousUser".equals(authentication.getPrincipal())) {
            logData.put("userInfo", "anonymous");
            return;
        }

        // 인증 정보가 있는 경우
        String userId = authenticateUtil.CheckWbUserAuthAndGetUserId(authentication);

        wbUserRepository.findById(userId).ifPresentOrElse(
                user -> logData.put("userInfo", WbUserLogDTO.fromEntity(user)),
                () -> logData.put("userInfo", "User not found for ID: " + userId)
        );
    }

    public static JobSearchLogDTO parseToDto(String jsonString) {
        // 1. 양쪽의 중괄호 제거
        jsonString = jsonString.trim().substring(1, jsonString.length() - 1);

        // 2. JSON 문자열을 키-값 쌍으로 분리
        String[] keyValuePairs = jsonString.split(",");
        Map<String, String> keyValueMap = new HashMap<>();

        for (String pair : keyValuePairs) {
            String[] keyValue = pair.split(":", 2); // `:` 기준으로 분리 (2개만 분리)
            String key = keyValue[0].trim().replaceAll("^\"|\"$", ""); // 양쪽 따옴표 제거
            String value = keyValue[1].trim().replaceAll("^\"|\"$", ""); // 양쪽 따옴표 제거

            keyValueMap.put(key, value.equals("null") ? null : value); // "null" 문자열은 null로 처리
        }

        // 3. DTO에 매핑
        return new JobSearchLogDTO(
                keyValueMap.get("entName"),
                keyValueMap.get("jobName"),
                keyValueMap.get("entAddr1")
        );
    }
}
