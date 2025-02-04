package com.example.myspringlab.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // ✅ 파일 경로를 웹에서 접근 가능하도록 설정 (403 오류 방지)
        registry.addResourceHandler("/files/**")
                .addResourceLocations("file:C:/MySpringLab/files/")
                .setCachePeriod(3600) // 1시간 캐싱
                .resourceChain(true);
    }
}
