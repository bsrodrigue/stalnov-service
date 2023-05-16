package com.example.novelservice.workshop.requests.novels;

import jakarta.validation.constraints.NotNull;

public record DeleteNovelRequest(@NotNull Long id) { }
