package com.techvista.userservice.service;

import com.techvista.userservice.dto.RegisterRequest;
import com.techvista.userservice.entity.User;
import com.techvista.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void register(RegisterRequest request) {

        if (repository.existsByEmail(request.email())) {
            throw new RuntimeException("Email already exists");
        }

        User user = User.builder()
                .email(request.email())
                .password(
                        passwordEncoder.encode(request.password())
                )
                .role("USER")
                .createdAt(LocalDateTime.now())
                .build();

        repository.save(user);
    }
}