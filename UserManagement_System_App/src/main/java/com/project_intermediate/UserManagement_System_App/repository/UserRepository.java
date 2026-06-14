package com.project_intermediate.UserManagement_System_App.repository;

import com.project_intermediate.UserManagement_System_App.entity.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByEmail(String email);

    boolean existsByEmail(@Email(message = "Invalid email") @NotBlank(message = "Email is required") String email);
}
