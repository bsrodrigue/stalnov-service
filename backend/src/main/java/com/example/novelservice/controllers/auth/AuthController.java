package com.example.novelservice.controllers.auth;

import com.example.novelservice.controllers.requests.CreateUserRequest;
import com.example.novelservice.models.User;
import com.example.novelservice.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/auth")
@RestController
@AllArgsConstructor
public class AuthController {
    private final UserService userService;


    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody CreateUserRequest request) throws Exception {
        try {
            var user = userService.createUser(request);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
