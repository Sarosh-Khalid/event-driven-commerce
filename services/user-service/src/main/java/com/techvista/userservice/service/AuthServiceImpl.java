package com.techvista.userservice.service;


import com.techvista.userservice.dto.*;
import com.techvista.userservice.entity.User;
import com.techvista.userservice.repository.UserRepository;
import com.techvista.userservice.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {


    private final UserRepository repository;

    private final PasswordEncoder encoder;

    private final JwtService jwtService;


    @Override
    public void register(RegisterRequest request) {


        if(repository.existsByEmail(request.email())) {
            throw new RuntimeException(
                    "Email already exists"
            );
        }


        User user =
                User.builder()
                        .email(request.email())
                        .password(
                                encoder.encode(request.password())
                        )
                        .role("USER")
                        .createdAt(
                                LocalDateTime.now()
                        )
                        .build();


        repository.save(user);
    }


    @Override
    public AuthResponse login(
            LoginRequest request) {


        User user =
                repository.findByEmail(request.email())
                        .orElseThrow(
                                () -> new RuntimeException("User not found")
                        );


        if(!encoder.matches(
                request.password(),
                user.getPassword())) {

            throw new RuntimeException(
                    "Invalid password"
            );
        }


        String token =
                jwtService.generateToken(
                        user.getEmail()
                );


        return new AuthResponse(token);
    }
}