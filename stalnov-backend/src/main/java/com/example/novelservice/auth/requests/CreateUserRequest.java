package com.example.novelservice.auth.requests;

import com.example.novelservice.auth.entities.Gender;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CreateUserRequest(
        @NotNull String email,
        @NotNull String password,
        String firstName,
        String lastName,
        Gender gender,
        @NotNull
        LocalDate birthdate,
        String avatarUrl,
        @NotNull String pseudo,
        String bio) {
}
