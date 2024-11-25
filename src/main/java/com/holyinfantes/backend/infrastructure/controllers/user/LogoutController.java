package com.holyinfantes.backend.infrastructure.controllers.user;

import com.holyinfantes.backend.domain.user.User;
import com.holyinfantes.backend.infrastructure.repository.user.UserRepository;
import com.holyinfantes.backend.infrastructure.security.service.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("api/auth")
public class LogoutController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/logout")
    public ResponseEntity<String> logout() {
        CustomUserDetails authenticatedUser = (CustomUserDetails) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();

        User user = authenticatedUser.getUser();

        user.setLastLogout(System.currentTimeMillis());
        userRepository.save(user);

        SecurityContextHolder.clearContext();

        return ResponseEntity.ok("Logout successful");
    }
}
