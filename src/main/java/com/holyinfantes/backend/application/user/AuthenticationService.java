package com.holyinfantes.backend.application.user;

import com.holyinfantes.backend.domain.user.User;
import com.holyinfantes.backend.infrastructure.repository.user.UserRepository;
import com.holyinfantes.backend.infrastructure.security.jwt.JwtTokenProvider;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private JwtTokenProvider tokenProvider;

    public LoginResponse login(String email, String password) {
        Optional<User> userOpt = userRepository.findByEmail(email);

        if (userOpt.isPresent()) {
            User user = userOpt.get();
            if(encoder.matches(password, user.getPassword())) {
                String token = tokenProvider.generateToken(user.getEmail(), user.getId());
                return new LoginResponse(token, user);
            }
        }

        throw new IllegalArgumentException("Invalid credentials");
    }


    @Data
    @AllArgsConstructor
    public static class LoginResponse {
        private String token;
        private User user;
    }
}
