package com.example.novelservice.workshop.requests.chapters;

import com.example.novelservice.common.entities.ChapterStatus;
import jakarta.validation.constraints.NotNull;

public record UpdateChapterRequest(
        @NotNull Long novelId,
        @NotNull Long id,
        @NotNull String title,
        String body,
        ChapterStatus status
) {
}
