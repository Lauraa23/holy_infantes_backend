package com.holyinfantes.backend.application.user;

import com.holyinfantes.backend.domain.user.User;
import com.holyinfantes.backend.infrastructure.repository.user.UserRepository;
import com.holyinfantes.backend.infrastructure.security.service.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DeleteUser {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void removeUser() {
        CustomUserDetails authenticatedUser = (CustomUserDetails) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();

        User user = authenticatedUser.getUser();

        userRepository.deleteById(user.getId());
    }

}
