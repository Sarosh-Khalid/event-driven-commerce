package com.techvista.userservice.service;

import com.techvista.userservice.dto.RegisterRequest;

public interface UserService {

    void register(RegisterRequest request);
}