package com.example.myspringlab.config;  // 적절한 패키지명 사용

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration  // 이 어노테이션을 통해 스프링 컨텍스트에 빈으로 등록됩니다.
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // 모든 경로에 대해 적용
                .allowedOrigins("http://localhost:5173")  // 프론트엔드 주소 (필요시 여러 주소 추가 가능)
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // 허용할 HTTP 메서드들
                .allowedHeaders("*")  // 모든 헤더 허용
                .allowCredentials(true);  // 쿠키나 인증 정보 사용 허용 (필요에 따라)
    }
}
