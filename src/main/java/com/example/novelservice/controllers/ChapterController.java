package com.example.novelservice.controllers;

import com.example.novelservice.models.Chapter;
import com.example.novelservice.repositories.ChapterRepository;
import org.springframework.stereotype.Component;

import java.util.List;

public class ChapterController {
}

@Component
class ChapterLoader {
    private final ChapterRepository chapterRepository;

    public ChapterLoader(ChapterRepository chapterRepository) {
        this.chapterRepository = chapterRepository;
    }

    private void loadChapters(){
        this.chapterRepository.saveAll(List.of(
                new Chapter("Prologue", "Behold the coomer")
        ));
    }

}
