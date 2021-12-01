package com.southwind.springboottest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 不加这个配置访问不到静态资源
        registry
                .addResourceHandler("/**")
                .addResourceLocations("classpath:/META-INF/resources/", "classpath:/resources/", "classpath:/static/", "classpath:/public/");

    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 跨域问题
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowedMethods("GET", "PUT", "POST", "DELETE", "HEAD", "OPTIONS")
                .allowCredentials(true)
                .maxAge(3600)
                .allowedHeaders("*");

    }
}