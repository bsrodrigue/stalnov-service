package com.example.novelservice.workshop.requests.novels;

import com.example.novelservice.common.entities.Genre;
import com.example.novelservice.common.entities.NovelStatus;
import jakarta.validation.constraints.NotNull;

public record UpdateNovelRequest(
                                 @NotNull Long id,
                                 String title,
                                 String description,
                                 String coverBase64,
                                 boolean isMature,
                                 Genre genre,
                                 NovelStatus status) {
}
