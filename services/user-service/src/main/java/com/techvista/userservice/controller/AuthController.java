package com.techvista.userservice.controller;

import com.techvista.userservice.dto.AuthResponse;
import com.techvista.userservice.dto.LoginRequest;
import com.techvista.userservice.dto.RegisterRequest;
import com.techvista.userservice.service.AuthService;
import com.techvista.userservice.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService service;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(
            @Valid
            @RequestBody RegisterRequest request) {

        service.register(request);
    }

    @PostMapping("/login")
    public AuthResponse login(
            @RequestBody LoginRequest request) {

        return service.login(request);
    }
}