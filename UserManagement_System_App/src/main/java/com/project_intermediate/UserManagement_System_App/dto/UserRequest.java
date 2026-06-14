package com.project_intermediate.UserManagement_System_App.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserRequest { // user signup request body
    @NotBlank(message = "Name is required")
    private String name;  // name dega

    @Email(message = "Invalid email")
    @NotBlank(message = "Email is required")
    private String email;  // email dega

    @NotBlank
    private String password; // and password
}
