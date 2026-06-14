package com.project_intermediate.UserManagement_System_App.service;

import com.project_intermediate.UserManagement_System_App.dto.UserRequest;
import com.project_intermediate.UserManagement_System_App.dto.UserResponse;
import com.project_intermediate.UserManagement_System_App.entity.Role;
import com.project_intermediate.UserManagement_System_App.entity.User;
import com.project_intermediate.UserManagement_System_App.exception.EmailAlreadyExistException;
import com.project_intermediate.UserManagement_System_App.exception.UserNotFoundException;
import com.project_intermediate.UserManagement_System_App.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    /*
     * Register User
     */
    public UserResponse createUser(UserRequest dto) {
        // first check ki is emial se koi pehle se exist to nhi karta
        if(userRepository.existsByEmail(dto.getEmail())) {
            // error throw kardo
            throw new EmailAlreadyExistException("Email is already registered ! ");
        }

        User user = User.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .role(Role.USER)  // sabhi ko user role me dalrhe hai
                .build();

        User savedUser = userRepository.save(user);

        return mapToResponse(savedUser);
    }

    /*
     * Get User By Id
     */
    public UserResponse getUserById(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new UserNotFoundException(
                                "User not found with id : " + id
                        ));

        return mapToResponse(user);
    }

    /*
     * Get All Users
     */
    public Page<UserResponse> getAllUsers(int page , int size,String sortBy) {

        // first page ko create karo
        // 1. Pageable object taiyar karo (Page Number, Size, aur Sorting mila kar)
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy).ascending());

        return userRepository.findAll(pageable)
                .map(this::mapToResponse);
    }

    /*
     * Update User
     */
    public UserResponse updateUser(Long id, UserRequest dto
    ) {

        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new UserNotFoundException(
                                "User not found with id : " + id
                        ));

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());

        User updatedUser =
                userRepository.save(user);

        return mapToResponse(updatedUser);
    }

    /*
     * Delete User
     */
    public String deleteUser(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new UserNotFoundException(
                                "User not found with id : " + id
                        ));

        userRepository.delete(user);

        return "User Deleted Successfully";
    }

    /*
     * Entity -> DTO
     */
    private UserResponse mapToResponse(User user) {

        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }


    public String deleteAllUsers() {
        userRepository.deleteAll();
        return "All Users deleted successfully!";
    }
}
