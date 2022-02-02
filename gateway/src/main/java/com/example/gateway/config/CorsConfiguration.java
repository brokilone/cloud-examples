package com.example.gateway.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;

@Configuration
public class CorsConfiguration implements WebFluxConfigurer {

  private static final String[] ALLOWED_HEADERS = {"x-requested-with", "authorization", "Content-Type", "Authorization", "credential", "X-XSRF-TOKEN"};
  private static final String[] ALLOWED_METHODS = {"GET", "PUT", "POST", "DELETE", "OPTIONS"};
  private static final String[] ALLOWED_ORIGINS = {"http://localhost:8060", "http://localhost:8080"};
  private static final Long MAX_AGE = 3600L;


  @Override
  public void addCorsMappings(CorsRegistry corsRegistry) {
    corsRegistry.addMapping("/**")
        .allowedOrigins(ALLOWED_ORIGINS)
        .allowedHeaders(ALLOWED_HEADERS)
        .allowedMethods(ALLOWED_METHODS)
        .allowCredentials(true)
        .maxAge(MAX_AGE);
  }
}

