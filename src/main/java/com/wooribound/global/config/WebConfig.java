package com.wooribound.global.config;

import com.wooribound.global.interceptor.JobClickHistoryLoggingInterceptor;
import com.wooribound.global.interceptor.JobSearchHistoryLoggingInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@RequiredArgsConstructor
@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final JobSearchHistoryLoggingInterceptor jobSearchHistoryLoggingInterceptor;
    private final JobClickHistoryLoggingInterceptor jobClickHistoryLoggingInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jobSearchHistoryLoggingInterceptor)
                .addPathPatterns("/api/individualuser/jobposting")
                .excludePathPatterns("/images/**", "/font/**", "/css/**", "/js/**");

        registry.addInterceptor(jobClickHistoryLoggingInterceptor)
                .addPathPatterns("/api/individualuser/jobposting/detail")
                .excludePathPatterns("/images/**", "/font/**", "/css/**", "/js/**");
    }
}
