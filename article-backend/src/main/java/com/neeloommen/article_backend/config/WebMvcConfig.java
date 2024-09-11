package com.neeloommen.article_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig {

    @Bean
    public WebMvcConfigurer corsConfig(){
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost")
                        .allowedMethods(HttpMethod.GET.name(),
                                HttpMethod.POST.name()
                                )
                        .allowedHeaders(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN,
                                HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS,
                                HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS);
            }
        };
    }
}
