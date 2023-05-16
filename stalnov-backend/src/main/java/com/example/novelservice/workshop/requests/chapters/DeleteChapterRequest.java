package com.example.novelservice.workshop.requests.chapters;

import jakarta.validation.constraints.NotNull;

public record DeleteChapterRequest(
        @NotNull Long novelId,
        @NotNull Long id
) {
}
