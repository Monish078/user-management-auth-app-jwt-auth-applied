package com.project_intermediate.UserManagement_System_App.controller;

import com.project_intermediate.UserManagement_System_App.dto.AuthResponse;
import com.project_intermediate.UserManagement_System_App.dto.LoginRequest;
import com.project_intermediate.UserManagement_System_App.dto.RegisterRequest;
import com.project_intermediate.UserManagement_System_App.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {  // --> phase 3 ke liye , register and login

    private final AuthService authService;

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {

        return authService.register(request);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }

}
