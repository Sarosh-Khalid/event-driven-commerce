package com.techvista.userservice.controller;


import com.techvista.userservice.entity.User;

import org.springframework.security.core.annotation.AuthenticationPrincipal;

import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/users")
public class UserController {


    @GetMapping("/me")
    public User profile(
            @AuthenticationPrincipal User user
    ) {

        return user;
    }
}