package com.wooribound.global.filters;

import org.springframework.web.util.ContentCachingResponseWrapper;

import jakarta.servlet.http.HttpServletResponse;

public class ResponseWrapper extends ContentCachingResponseWrapper {
    public ResponseWrapper(HttpServletResponse response) {
        super(response);
    }
}