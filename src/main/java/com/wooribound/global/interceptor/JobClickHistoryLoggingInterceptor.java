package com.wooribound.global.interceptor;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wooribound.domain.wbuser.WbUserRepository;
import com.wooribound.global.interceptor.dto.JobPostingLogDTO;
import com.wooribound.global.interceptor.dto.WbUserLogDTO;
import com.wooribound.global.interceptor.service.JobPostingLogService;
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
public class JobClickHistoryLoggingInterceptor implements HandlerInterceptor {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private final AuthenticateUtil authenticateUtil;
    private final WbUserRepository wbUserRepository;
    private final JobPostingLogService jobPostingLogService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if ("GET".equalsIgnoreCase(request.getMethod())) {
            MDC.put("traceId", String.format("[%s]", UUID.randomUUID()));

            Map<String, Object> jobSearchHistoryLog = new HashMap<>();

            // API METHOD 담기
            jobSearchHistoryLog.put("method", request.getMethod());
            // URL 담기
            jobSearchHistoryLog.put("url", request.getRequestURI());
            // USER INFO 담기
            logUserInfo(jobSearchHistoryLog);
            // parameters 담기
            parseToDto(request, jobSearchHistoryLog);

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

    private void parseToDto(HttpServletRequest request, Map<String, Object> jobSearchHistoryLog) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        Map<String, String> parameters = new HashMap<>();

        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
            String paramName = entry.getKey();
            String[] paramValues = entry.getValue();

            for (String paramValue : paramValues) {
                parameters.put(paramName, paramValue);
            }
        }

        String postId = parameters.get("postId");
        JobPostingLogDTO jobPostingLog = jobPostingLogService.getJobPostingLog(Long.valueOf(postId));

        if (jobPostingLog != null) {
            jobSearchHistoryLog.put("jobPostingInfo", jobPostingLog);
        } else {
            jobSearchHistoryLog.put("JobPostingInfo not found for ID: ", Long.valueOf(postId));
        }
    }
}
