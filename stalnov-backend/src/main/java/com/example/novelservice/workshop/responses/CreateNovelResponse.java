package com.example.novelservice.workshop.responses;

import com.example.novelservice.common.entities.Novel;
import lombok.Builder;

@Builder
public record CreateNovelResponse(String status, String message, Novel novel) {
}
