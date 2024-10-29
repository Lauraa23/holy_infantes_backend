package com.holyinfantes.backend.application.user;

import com.holyinfantes.backend.domain.user.CreateUserDto;
import com.holyinfantes.backend.domain.user.User;
import com.holyinfantes.backend.domain.user.exception.UserAlreadyExistException;
import com.holyinfantes.backend.infrastructure.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CreateUser {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    public void createUser(CreateUserDto request) {

        if(repository.findByEmail(request.getEmail()).isPresent()) {
            throw new UserAlreadyExistException("User already exist");
        }

        User user = new User();
        user.setName(request.getName());
        user.setSurname(request.getSurname());
        user.setEmail(request.getEmail());
        user.setPassword(encoder.encode(request.getPassword()));

        repository.save(user);
    }
}
