package com.example.novelservice.services;

import com.example.novelservice.models.Chapter;
import com.example.novelservice.models.Novel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class NovelService {

  @PersistenceContext private EntityManager entityManager;

  @Transactional
  public void addChapterToNovel(Novel novel, Chapter chapter) {
    chapter.setNovel(novel);
    novel.getChapters().add(chapter);
    entityManager.persist(novel);
    entityManager.persist(chapter);
  }
}
