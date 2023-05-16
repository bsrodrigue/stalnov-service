package com.example.novelservice.workshop.services;

import com.example.novelservice.auth.entities.User;
import com.example.novelservice.auth.exceptions.UserNotAuthorException;
import com.example.novelservice.auth.repositories.UserRepository;
import com.example.novelservice.common.entities.*;
import com.example.novelservice.common.repositories.ChapterRepository;
import com.example.novelservice.common.repositories.NovelRepository;
import com.example.novelservice.workshop.requests.chapters.CreateChapterRequest;
import com.example.novelservice.workshop.requests.chapters.DeleteChapterRequest;
import com.example.novelservice.workshop.requests.chapters.UpdateChapterRequest;
import com.example.novelservice.workshop.requests.novels.CreateNovelRequest;
import com.example.novelservice.workshop.requests.novels.DeleteNovelRequest;
import com.example.novelservice.workshop.requests.novels.UpdateNovelRequest;
import com.example.novelservice.workshop.responses.CreateNovelResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.function.Consumer;

@Service
@RequiredArgsConstructor
public class WorkshopService {
    private final NovelRepository novelRepository;
    private final ChapterRepository chapterRepository;
    private final UserRepository userRepository;

    private void checkAuthorship(User user, Novel novel) throws UserNotAuthorException {
        if (!novel.getAuthor().getId().equals(user.getId())) throw new UserNotAuthorException();
    }

    public String createChapter(User user, CreateChapterRequest request) throws UserNotAuthorException {
        var novel = novelRepository.findById(request.novelId()).orElseThrow();
        checkAuthorship(user, novel);

        var chapter = Chapter
                .builder()
                .title(request.title())
                .body(request.body())
                .status(Optional.ofNullable(request.status()).orElse(ChapterStatus.DRAFT))
                .novel(novel)
                .build();

        novel.getChapters().add(chapter);

        novelRepository.save(novel);

        return "Chapter created with success";
    }

    public String updateChapter(User user, UpdateChapterRequest request) throws UserNotAuthorException {
        var novel = novelRepository.findById(request.novelId()).orElseThrow();
        checkAuthorship(user, novel);

        var chapter = chapterRepository.findById(request.id()).orElseThrow();

        updateField(request.title(), chapter::setTitle);
        updateField(request.body(), chapter::setBody);
        updateField(request.status(), chapter::setStatus);

        chapterRepository.save(chapter);

        return "Chapter updated with success";
    }

    public String deleteChapter(User user, DeleteChapterRequest request) throws UserNotAuthorException {
        var novel = novelRepository.findById(request.novelId()).orElseThrow();
        checkAuthorship(user, novel);

        chapterRepository.deleteById(request.novelId());

        return "Chapter deleted with success";
    }

    public CreateNovelResponse createNovel(User user, CreateNovelRequest request) {
        var novel = Novel
                .builder()
                .title(request.title())
                .description("New Novel")
                .author(user)
                .status(NovelStatus.DRAFT)
                .genre(Genre.UNKNOWN)
                .coverUrl("")
                .isMature(false)
                .chapters(new ArrayList<>())
                .build();

        user.getCreations().add(novel);

        novelRepository.save(novel);
        userRepository.save(user);

        return new CreateNovelResponse(HttpStatus.CREATED.toString(), "Novel created with success", novel);
    }

    public String deleteNovel(User user, DeleteNovelRequest request) throws UserNotAuthorException {
        var novel = novelRepository.findById(request.id()).orElseThrow();
        checkAuthorship(user, novel);
        novelRepository.delete(novel);

        return "Novel deleted successfully";
    }

    public String updateNovel(User user, UpdateNovelRequest request) throws UserNotAuthorException {
        var novel = novelRepository.findById(request.id()).orElseThrow();
        checkAuthorship(user, novel);

        updateField(request.title(), novel::setTitle);
        updateField(request.description(), novel::setDescription);
        updateField(request.coverBase64(), novel::setCoverUrl);
        updateField(request.status(), novel::setStatus);
        updateField(request.isMature(), novel::setMature);
        updateField(request.genre(), novel::setGenre);

        novelRepository.save(novel);

        return "Novel updated with success";
    }

    private <T> void updateField(T value, Consumer<T> fieldUpdater) {
        Optional.ofNullable(value).ifPresent(fieldUpdater);
    }
}
