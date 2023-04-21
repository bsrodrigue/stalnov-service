package com.example.novelservice.controllers;

import com.example.novelservice.models.Genre;
import com.example.novelservice.models.Novel;
import com.example.novelservice.repositories.NovelRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/novels")
public class NovelController {
    private final NovelRepository novelRepository;

    public NovelController(NovelRepository novelRepository){
        this.novelRepository = novelRepository;
    }

    @GetMapping
    public Iterable<Novel> getAllNovels(){
        return  this.novelRepository.findAll();
    }
}
