package com.wooribound.global.config;

import com.wooribound.global.filters.LoggingFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig
{
    @Bean(name = "LoggingFilter")
    public FilterRegistrationBean<LoggingFilter> loggingFilter() {
        FilterRegistrationBean<LoggingFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new LoggingFilter());
        registrationBean.addUrlPatterns("/api/individualuser/jobposting", "/api/individualuser/jobposting/detail");
        registrationBean.setOrder(1);
        return registrationBean;
    }
}
