package org.example.demo.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecureController {

    @GetMapping("/secure")
    public String secure(@AuthenticationPrincipal Jwt jwt) {
        return "This is a secure endpoint. Authenticated subject: " + jwt.getSubject();
    }
}