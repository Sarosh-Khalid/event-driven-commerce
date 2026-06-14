package com.techvista.userservice.service;

import com.techvista.userservice.dto.AuthResponse;
import com.techvista.userservice.dto.LoginRequest;
import com.techvista.userservice.dto.RegisterRequest;

public interface AuthService {

    void register(RegisterRequest request);

    AuthResponse login(LoginRequest request);
}