package com.holyinfantes.backend.infrastructure.controllers.user;

import com.holyinfantes.backend.application.user.CreateUser;
import com.holyinfantes.backend.domain.user.CreateUserDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("/api/createUser")
public class CreateUserController {

    @Autowired
    private CreateUser createUser;


    @PostMapping
    public ResponseEntity<String> createUser(@Valid @RequestBody CreateUserDto request) {
        createUser.createUser(request);
        return new ResponseEntity<>("User created successfully", HttpStatus.CREATED);
    }
}