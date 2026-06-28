package com.techvista.apigateway.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;


@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {



    @Bean
    SecurityWebFilterChain security(
            org.springframework.security.config.web.server.ServerHttpSecurity http
    ){

        return http

                .csrf(
                        csrf -> csrf.disable()
                )

                .authorizeExchange(
                        exchange ->
                                exchange.anyExchange()
                                        .permitAll()
                )

                .build();
    }

}