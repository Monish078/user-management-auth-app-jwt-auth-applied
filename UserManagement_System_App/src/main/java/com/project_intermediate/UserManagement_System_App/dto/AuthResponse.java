package com.project_intermediate.UserManagement_System_App.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponse { // phase 4 jwt auth  , ye token bhejega response me

    private String token;
}
