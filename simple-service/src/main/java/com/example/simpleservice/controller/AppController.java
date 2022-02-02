package com.example.simpleservice.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/simple-service")
public class AppController {

  @PreAuthorize("hasAuthority('SCOPE_TEST')")
  @GetMapping("/ping")
  public String ping() {
    var auth = SecurityContextHolder.getContext()
        .getAuthentication();
    return "Scopes: " + auth.getAuthorities();
  }
}
