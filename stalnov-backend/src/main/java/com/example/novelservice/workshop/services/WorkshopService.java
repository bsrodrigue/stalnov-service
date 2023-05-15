package com.example.novelservice.workshop.services;

import com.example.novelservice.auth.entities.User;
import com.example.novelservice.auth.exceptions.UserNotAuthorException;
import com.example.novelservice.auth.repositories.UserRepository;
import com.example.novelservice.common.entities.Genre;
import com.example.novelservice.common.entities.Novel;
import com.example.novelservice.common.entities.NovelStatus;
import com.example.novelservice.common.repositories.NovelRepository;
import com.example.novelservice.workshop.requests.CreateNovelRequest;
import com.example.novelservice.workshop.requests.DeleteNovelRequest;
import com.example.novelservice.workshop.requests.UpdateNovelRequest;
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
    private final UserRepository userRepository;

    private boolean isAuthor(User user, Novel novel) {
        return novel.getAuthor().getId().equals(user.getId());
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
        if (!isAuthor(user, novel)) throw new UserNotAuthorException();
        novelRepository.delete(novel);

        return "Novel deleted successfully";
    }

    public String updateNovel(User user, UpdateNovelRequest request) throws UserNotAuthorException {
        var novel = novelRepository.findById(request.id()).orElseThrow();
        if (!isAuthor(user, novel)) throw new UserNotAuthorException();

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
