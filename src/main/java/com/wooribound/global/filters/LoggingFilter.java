package com.wooribound.global.filters;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingResponseWrapper;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;


@Component
@Slf4j
public class LoggingFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        MDC.put("traceId", String.format("[%s]", UUID.randomUUID()));
        if (isAsyncDispatch(request)) {
            filterChain.doFilter(request, response);
        } else {
            doFilterWrapped(new RequestWrapper(request), new ResponseWrapper(response), filterChain);
        }
        MDC.clear();
    }

    protected void doFilterWrapped(RequestWrapper request, ContentCachingResponseWrapper response, FilterChain filterChain) throws ServletException, IOException {
        boolean isLog = false;

        try {
            isLog = logRequest(request);
            filterChain.doFilter(request, response);
        } finally {
            if(isLog) logResponse(response);
            response.copyBodyToResponse();
        }
    }

    private boolean logRequest(RequestWrapper request) throws IOException {
        String url = request.getRequestURI();
        if(url.startsWith("/images") ||
                url.startsWith("/font") ||
                url.startsWith("/css") ||
                url.startsWith("/js")) {
            return false;
        }

        String queryString = request.getQueryString();
        log.info("[{}][{}][{}]",
                request.getMethod(),
                request.getRequestURI(),
                queryString
        );

        String content = getContent(request.getInputStream());
        if (StringUtils.hasText(content)) {
            log.info("Request Payload - {}", content);
        }

        return true;
    }

    private void logResponse(ContentCachingResponseWrapper response) throws IOException {
        int status = response.getStatus();
        log.info("Response Status - {}", status);

        if (status != 200) {
            log.info("Response Payload - {}", getContent(response.getContentInputStream()));
        }
    }

    private String getContent(InputStream inputStream) throws IOException{
        byte[] content = StreamUtils.copyToByteArray(inputStream);
        if (content.length > 0) {
            return new String(content);
        } else {
            return null;
        }
    }

}
