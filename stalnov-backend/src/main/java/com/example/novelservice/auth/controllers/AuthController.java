package com.example.novelservice.auth.controllers;

import com.example.novelservice.auth.entities.Role;
import com.example.novelservice.auth.entities.User;
import com.example.novelservice.auth.repositories.UserRepository;
import com.example.novelservice.auth.requests.CreateUserRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/auth")
@RequiredArgsConstructor
@RestController
public class AuthController {
    private final UserRepository userRepository;


    @PostMapping("/register")
    public ResponseEntity<User> register(@Valid @RequestBody CreateUserRequest request) {
        var user = User.builder()
                .bio(request.bio())
                .avatarUrl(request.avatarUrl())
                .birthdate(request.birthdate())
                .email(request.email())
                .role(Role.USER)
                .gender(request.gender())
                .pseudo(request.pseudo())
                .lastName(request.lastName())
                .firstName(request.firstName())
                .password(request.password())
                .build();

        userRepository.save(user);

        return ResponseEntity.ok(user);
    }
}
