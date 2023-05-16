package com.example.novelservice.common.repositories;

import com.example.novelservice.common.entities.Chapter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChapterRepository extends JpaRepository<Chapter, Long> {
}
