package com.techvista.userservice.controller;

import com.techvista.userservice.dto.RegisterRequest;
import com.techvista.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService service;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public void register(
            @RequestBody RegisterRequest request) {

        service.register(request);
    }
}