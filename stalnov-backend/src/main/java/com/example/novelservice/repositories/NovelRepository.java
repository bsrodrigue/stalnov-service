package com.example.novelservice.repositories;

import com.example.novelservice.models.Novel;
import org.springframework.data.repository.CrudRepository;

public interface NovelRepository extends CrudRepository<Novel, Long> {}
