package com.example.novelservice.auth.requests;

import jakarta.validation.constraints.NotNull;

public record DeleteAccountRequest(
        @NotNull String email) {
}
