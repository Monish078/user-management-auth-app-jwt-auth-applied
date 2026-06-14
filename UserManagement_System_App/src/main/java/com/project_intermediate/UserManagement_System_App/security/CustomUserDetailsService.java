package com.project_intermediate.UserManagement_System_App.security;


import com.project_intermediate.UserManagement_System_App.entity.User;
import com.project_intermediate.UserManagement_System_App.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {  //  ye file phase 3 ke liye hai , db se user dundna and passwod match karna

    private final UserRepository userRepository;
    // sabse important class jab user ki db se check hota hai - phase 3 me

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {  // user db se load hota hai

        User user =
                userRepository.findByEmail(email)
                        .orElseThrow(() ->
                                new UsernameNotFoundException(
                                        "User Not Found"
                                ));

        return org.springframework.security.core.userdetails
                .User
                .builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .roles(user.getRole().name())
                .build();
    }

}
