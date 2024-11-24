package com.holyinfantes.backend.infrastructure.controllers.user;

import com.holyinfantes.backend.application.user.AuthenticationService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class LoginController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<AuthenticationService.LoginResponse> login(@RequestBody LoginRequest request) {
        AuthenticationService.LoginResponse loginResponse = authenticationService
                .login(request.getEmail(), request.getPassword());
        return ResponseEntity.ok(loginResponse);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class LoginRequest {
        private String email;
        private String password;

    }
}
