package com.example.notes_service.dto;

import lombok.Getter;

import java.util.Date;

@Getter
public class ErrorInfo {
    private final Date timestamp;
    private final String message;
    private final String details;

    public ErrorInfo(Date timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }
}
