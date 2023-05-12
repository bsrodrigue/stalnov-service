package com.example.novelservice.services;

import com.example.novelservice.models.Novel;
import com.example.novelservice.repositories.NovelRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NovelService {
    private final NovelRepository novelRepository;

    public void createNovel(Novel novel) {
        novelRepository.save(novel);
    }

}
