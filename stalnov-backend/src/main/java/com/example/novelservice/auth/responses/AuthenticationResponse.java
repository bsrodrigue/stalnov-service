package com.example.novelservice.auth.responses;

import lombok.Builder;

@Builder
public record AuthenticationResponse(String status, String message, String token) {
}
