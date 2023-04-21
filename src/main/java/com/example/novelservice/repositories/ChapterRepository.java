package com.example.novelservice.repositories;

import com.example.novelservice.models.Chapter;
import org.springframework.data.repository.CrudRepository;

public interface ChapterRepository extends CrudRepository<Chapter, Long> {
}
