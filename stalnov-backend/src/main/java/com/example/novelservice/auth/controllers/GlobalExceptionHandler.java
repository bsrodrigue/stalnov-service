package com.example.novelservice.auth.controllers;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException e) {
        List<String> errors = e.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField() + " " + error.getDefaultMessage())
                .collect(Collectors.toList());

        ErrorResponse response = new EResponse(HttpStatus.BAD_REQUEST.value(), "Validation Error", errors);
        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handleConstraintException(SQLIntegrityConstraintViolationException e) {

        ErrorResponse response = new EResponse(HttpStatus.BAD_REQUEST.value(), "Constraint Error", List.of(e.getMessage()));
        return ResponseEntity.badRequest().body(response);
    }

    @Data
    @AllArgsConstructor
    protected static class EResponse implements ErrorResponse {
        private int status;
        private String message;
        private List<String> errors;

        @Override
        public HttpStatusCode getStatusCode() {
            return HttpStatusCode.valueOf(status);
        }

        @Override
        public ProblemDetail getBody() {
            return ProblemDetail.forStatus(status);
        }
    }
}
