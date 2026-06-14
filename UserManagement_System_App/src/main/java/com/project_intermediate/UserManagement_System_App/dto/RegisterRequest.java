package com.project_intermediate.UserManagement_System_App.dto;

import lombok.Data;

@Data
public class RegisterRequest {  // phase -3 me

    private String name;

    private String email;

    private String password;
}
