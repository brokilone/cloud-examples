package com.example.gateway.config;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;


@EnableWebFluxSecurity
public class SecurityConfiguration {

  @Bean
  public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
    return http.authorizeExchange()
        .pathMatchers("/test")
        .permitAll()
        .anyExchange()
        .authenticated()
        .and().oauth2Login(withDefaults())
        .csrf().disable()
        .build();
  }
}
