package com.example.notes_service.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class APIException extends RuntimeException {
    private final HttpStatus status;
    private final String message;
}
