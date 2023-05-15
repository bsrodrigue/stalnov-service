package com.example.novelservice.workshop.requests;

import com.example.novelservice.common.entities.Genre;
import jakarta.validation.constraints.NotNull;

public record CreateNovelRequest(
        @NotNull String title,
        String description,
        String coverBase64,
        boolean isMature,
        Genre genre) {
}
