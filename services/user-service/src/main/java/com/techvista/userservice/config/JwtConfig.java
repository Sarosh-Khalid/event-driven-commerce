package com.techvista.userservice.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConfig {

    public static final long EXPIRATION =
            86400000; // 24 hours
}