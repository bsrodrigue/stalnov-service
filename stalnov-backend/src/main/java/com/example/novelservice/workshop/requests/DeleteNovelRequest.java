package com.example.novelservice.workshop.requests;

import jakarta.validation.constraints.NotNull;

public record DeleteNovelRequest(@NotNull Long id) { }
