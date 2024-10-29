package com.holyinfantes.backend.infrastructure.repository.user;

import com.holyinfantes.backend.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository  extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}