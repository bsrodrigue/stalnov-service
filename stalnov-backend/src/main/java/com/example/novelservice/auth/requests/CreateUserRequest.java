package com.example.novelservice.auth.requests;

import com.example.novelservice.auth.entities.Gender;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public record CreateUserRequest(
        @NotNull String email,
        @NotNull String password,
        @NotNull
        LocalDate birthdate,
        @NotNull String pseudo,
        String firstName,
        String lastName,
        Gender gender,
        String avatarUrl,
        String bio) {
}
