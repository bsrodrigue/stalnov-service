package com.example.novelservice.workshop.requests.chapters;

import com.example.novelservice.common.entities.ChapterStatus;
import jakarta.validation.constraints.NotNull;

public record CreateChapterRequest(
        @NotNull Long novelId,
        @NotNull String title,
        String body,
        ChapterStatus status) {
}
