package com.example.application_management_system.config;

import com.example.application_management_system.interceptor.LoggingInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    LoggingInterceptor loggingInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {//register our LoggingInterceptor inside InterceptorRegistry
        registry.addInterceptor(loggingInterceptor)
                .addPathPatterns("/api/**")//all the path starting with /api will be intercepted.
                .excludePathPatterns("/api/auth/**");//any auth api will be excluded to be intercepted.
    }
}
