package com.example.novelservice.common.repositories;

import com.example.novelservice.common.entities.Novel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NovelRepository extends JpaRepository<Novel, Long> {
}
