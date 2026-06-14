package com.techvista.userservice.dto;

public record RegisterRequest(
        String email,
        String password
) {
}