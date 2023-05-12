package com.example.novelservice.common.responses;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@RequiredArgsConstructor
public class SuccessResponse {
    protected HttpStatus status;
    protected String message;
}
