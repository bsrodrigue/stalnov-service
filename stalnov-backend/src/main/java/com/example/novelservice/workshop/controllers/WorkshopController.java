package com.example.novelservice.workshop.controllers;

import com.example.novelservice.auth.entities.User;
import com.example.novelservice.auth.exceptions.UserNotAuthorException;
import com.example.novelservice.auth.exceptions.UserNotFoundException;
import com.example.novelservice.auth.services.JwtService;
import com.example.novelservice.auth.services.UserService;
import com.example.novelservice.workshop.requests.chapters.CreateChapterRequest;
import com.example.novelservice.workshop.requests.chapters.DeleteChapterRequest;
import com.example.novelservice.workshop.requests.chapters.UpdateChapterRequest;
import com.example.novelservice.workshop.requests.novels.CreateNovelRequest;
import com.example.novelservice.workshop.requests.novels.DeleteNovelRequest;
import com.example.novelservice.workshop.requests.novels.UpdateNovelRequest;
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
        var user = getUserFromHeader(authHeader);
        var response = workshopService.createNovel(user, request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/delete-novel")
    public ResponseEntity<?> deleteNovel(
            @RequestHeader("Authorization") String authHeader,
            @Valid @RequestBody DeleteNovelRequest request) throws UserNotFoundException, UserNotAuthorException {
        var user = getUserFromHeader(authHeader);
        var response = workshopService.deleteNovel(user, request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/update-novel")
    public ResponseEntity<?> updateNovel(
            @RequestHeader("Authorization") String authHeader,
            @Valid @RequestBody UpdateNovelRequest request) throws UserNotFoundException, UserNotAuthorException {
        var user = getUserFromHeader(authHeader);
        var response = workshopService.updateNovel(user, request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/create-chapter")
    public ResponseEntity<?> createChapter(
            @RequestHeader("Authorization") String authHeader,
            @Valid @RequestBody CreateChapterRequest request) throws UserNotFoundException, UserNotAuthorException {
        var user = getUserFromHeader(authHeader);
        var response = workshopService.createChapter(user, request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/delete-chapter")
    public ResponseEntity<?> deleteChapter(
            @RequestHeader("Authorization") String authHeader,
            @Valid @RequestBody DeleteChapterRequest request) throws UserNotFoundException, UserNotAuthorException {
        var user = getUserFromHeader(authHeader);
        var response = workshopService.deleteChapter(user, request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/update-chapter")
    public ResponseEntity<?> updateChapter(
            @RequestHeader("Authorization") String authHeader,
            @Valid @RequestBody UpdateChapterRequest request) throws UserNotFoundException, UserNotAuthorException {
        var user = getUserFromHeader(authHeader);
        var response = workshopService.updateChapter(user, request);
        return ResponseEntity.ok(response);
    }

    private User getUserFromHeader(String authHeader) throws UserNotFoundException {
        var token = authHeader.substring(7);
        var userEmail = jwtService.extractUsername(token);
        return userService.loadUserByUsername(userEmail);
    }
}
