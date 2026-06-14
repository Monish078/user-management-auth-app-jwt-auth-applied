package com.project_intermediate.UserManagement_System_App.controller;

import com.project_intermediate.UserManagement_System_App.dto.UserRequest;
import com.project_intermediate.UserManagement_System_App.dto.UserResponse;
import com.project_intermediate.UserManagement_System_App.service.UserService;
import lombok.RequiredArgsConstructor;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /*
     * Register User
     */
    @PostMapping
    public UserResponse createUser(@Valid @RequestBody UserRequest dto) {
        return userService.createUser(dto);
    }

    /*
     * Get User By Id
     */
    @GetMapping("/{id}")
    public UserResponse getUserById(
            @PathVariable Long id
    ) {
        return userService.getUserById(id);
    }

    /*
     * Get All Users
     */
    @GetMapping
    public Page<UserResponse> getAllUsers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy) {
        return userService.getAllUsers(page , size,sortBy);
    }

    /*
     * Update User
     */
    @PutMapping("/{id}")
    public UserResponse updateUser(@PathVariable Long id, @RequestBody UserRequest dto) {
        return userService.updateUser(id, dto);
    }

    /*
     * Delete User
     */
    @DeleteMapping("/{id}")
    public String deleteUser(
            @PathVariable Long id
    ) {
        return userService.deleteUser(id);
    }

    @DeleteMapping()
    public String deleteAllUsers() {
        return userService.deleteAllUsers();
    }



}
