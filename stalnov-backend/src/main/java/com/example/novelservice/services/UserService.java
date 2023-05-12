package com.example.novelservice.services;

import com.example.novelservice.controllers.requests.CreateUserRequest;
import com.example.novelservice.models.Role;
import com.example.novelservice.models.User;
import com.example.novelservice.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void updateUser(User user) {
        userRepository.save(user);
    }

    public User getUserById(Long Id) throws Exception {
        return userRepository.findById(Id).orElseThrow();
    }


    public User createUser(CreateUserRequest request) throws Exception {

        if (userRepository.existsByUsername(request.getEmail())) {
            throw new Exception("User already exists");
        }

        var userBuilder = User.builder()
                .username(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .role(Role.USER);

        if (request.getBio() != null) {
            userBuilder.bio(request.getBio());
        }

        var user = userBuilder.build();

        userRepository.save(user);

        return user;
    }

}
