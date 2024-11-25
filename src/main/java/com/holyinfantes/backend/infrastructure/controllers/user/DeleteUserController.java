package com.holyinfantes.backend.infrastructure.controllers.user;

import com.holyinfantes.backend.application.user.DeleteUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("api/user")
public class DeleteUserController {

    @Autowired
    private DeleteUser service;

    @PostMapping("/deleteUser")
    public ResponseEntity<String> deleteUser() {
        service.removeUser();

        return ResponseEntity.ok("User deleted successfully");
    }
}
