package com.techvista.userservice.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConfig {

    public static final String SECRET =
            "my-super-long-secret-key-for-event-driven-commerce-platform-jwt-authentication-2026";

    public static final long EXPIRATION =
            86400000; // 24 hours
}