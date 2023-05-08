package com.example.novelservice.controllers;

import com.example.novelservice.models.Novel;
import com.example.novelservice.repositories.NovelRepository;
import com.example.novelservice.services.NovelService;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/novels")
public class NovelController {
  private final NovelRepository novelRepository;

  public NovelController(NovelRepository novelRepository,
                         NovelService novelService) {
    this.novelRepository = novelRepository;
  }

  @GetMapping("/{id}")
  public ResponseEntity<Novel>
  getNovelById(@PathVariable(name = "id") Long id) {
    Optional<Novel> novel = this.novelRepository.findById(id);

    if (novel.isEmpty()) {
      return ResponseEntity.notFound().build();
    }

    return ResponseEntity.ok(novel.get());
  }

  @GetMapping
  public ResponseEntity<Iterable<Novel>> getAllNovels() {
    return ResponseEntity.ok(this.novelRepository.findAll());
  }

  @PostMapping
  public ResponseEntity<Novel> createNovel(@RequestBody Novel novel) {
    this.novelRepository.save(novel);
    return ResponseEntity.ok(novel);
  }
}
