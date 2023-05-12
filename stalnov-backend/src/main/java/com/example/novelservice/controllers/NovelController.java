package com.example.novelservice.controllers;

import com.example.novelservice.controllers.requests.CreateNovelRequest;
import com.example.novelservice.models.Genre;
import com.example.novelservice.models.Novel;
import com.example.novelservice.services.NovelService;
import com.example.novelservice.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/novels")
@AllArgsConstructor
public class NovelController {
    private final NovelService novelService;
    private final UserService userService;

    @PostMapping
    public ResponseEntity<Novel> createNovel(@RequestBody CreateNovelRequest request) throws Exception {
        var user = userService.getUserById(1L);
        var novel = Novel.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .genre(Genre.valueOf(request.getGenre()))
                .build();

        novel.setAuthor(user);
        user.getCreations().add(novel);

        userService.updateUser(user);
        novelService.createNovel(novel);
        return ResponseEntity.ok(novel);
    }
}
