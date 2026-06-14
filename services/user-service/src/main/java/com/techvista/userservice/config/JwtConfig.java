package com.techvista.userservice.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConfig {

    public static final String SECRET =
            "my-super-secret-key-for-commerce-project-123456";

    public static final long EXPIRATION =
            86400000; // 24 hours
}