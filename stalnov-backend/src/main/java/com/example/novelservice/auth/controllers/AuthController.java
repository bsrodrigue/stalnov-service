package com.example.novelservice.auth.controllers;

import com.example.novelservice.auth.exceptions.UserNotFoundException;
import com.example.novelservice.auth.requests.CreateUserRequest;
import com.example.novelservice.auth.requests.DeleteAccountRequest;
import com.example.novelservice.auth.responses.AuthResponses;
import com.example.novelservice.auth.services.UserService;
import com.example.novelservice.common.responses.SuccessResponse;
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
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<SuccessResponse> register(@Valid @RequestBody CreateUserRequest request) {
        userService.createUserFromRequest(request);
        return ResponseEntity.ok(new AuthResponses.CreateUserResponse());
    }

    @PostMapping("/delete-account")
    public ResponseEntity<SuccessResponse> deleteAccount(@Valid @RequestBody DeleteAccountRequest request) throws UserNotFoundException {
        userService.deleteUserAccountFromRequest(request);
        return ResponseEntity.ok(new AuthResponses.DeleteAccountResponse());
    }
}
