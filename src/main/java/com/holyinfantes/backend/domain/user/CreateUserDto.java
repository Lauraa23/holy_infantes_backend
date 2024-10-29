package com.holyinfantes.backend.domain.user;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateUserDto {
    @NotBlank(message = "Name can not be empty")
    private String name;
    @NotBlank(message = "Surname can not be empty")
    private String surname;
    @NotBlank(message = "Email can not be empty")
    private String email;
    @NotBlank(message = "Password can not be empty")
    private String password;
}
