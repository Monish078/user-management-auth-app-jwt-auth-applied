package com.project_intermediate.UserManagement_System_App.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {  // user entity

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String password; // bcrypt password save hoga

    @Enumerated(EnumType.STRING)  // database me USER ADMIN string me store hoga , 0 1 store nhi hoga
    private Role role;

}
