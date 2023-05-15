package com.example.novelservice.workshop.controllers;

import com.example.novelservice.auth.exceptions.UserNotAuthorException;
import com.example.novelservice.auth.exceptions.UserNotFoundException;
import com.example.novelservice.auth.services.JwtService;
import com.example.novelservice.auth.services.UserService;
import com.example.novelservice.workshop.requests.CreateNovelRequest;
import com.example.novelservice.workshop.requests.DeleteNovelRequest;
import com.example.novelservice.workshop.requests.UpdateNovelRequest;
import com.example.novelservice.workshop.services.WorkshopService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/workshop")
@RequiredArgsConstructor
public class WorkshopController {
    private final JwtService jwtService;
    private final UserService userService;
    private final WorkshopService workshopService;


    @PostMapping("/create-novel")
    public ResponseEntity<?> createNovel(
            @RequestHeader("Authorization") String authHeader,
            @Valid @RequestBody CreateNovelRequest request) throws UserNotFoundException {
        var token = authHeader.substring(7);
        var userEmail = jwtService.extractUsername(token);
        var user = userService.loadUserByUsername(userEmail);
        var response = workshopService.createNovel(user, request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/delete-novel")
    public ResponseEntity<?> deleteNovel(
            @RequestHeader("Authorization") String authHeader,
            @Valid @RequestBody DeleteNovelRequest request) throws UserNotFoundException, UserNotAuthorException {
        var token = authHeader.substring(7);
        var userEmail = jwtService.extractUsername(token);
        var user = userService.loadUserByUsername(userEmail);
        var response = workshopService.deleteNovel(user, request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/update-novel")
    public ResponseEntity<?> updateNovel(
            @RequestHeader("Authorization") String authHeader,
            @Valid @RequestBody UpdateNovelRequest request) throws UserNotFoundException, UserNotAuthorException {
        var token = authHeader.substring(7);
        var userEmail = jwtService.extractUsername(token);
        var user = userService.loadUserByUsername(userEmail);
        var response = workshopService.updateNovel(user, request);
        return ResponseEntity.ok(response);
    }
}
