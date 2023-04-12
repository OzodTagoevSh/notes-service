package com.example.notes_service.exception;

import com.example.notes_service.dto.ErrorInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<ErrorInfo> handleResourceNotFound(ResourceNotFound resourceNotFound, WebRequest webRequest) {
        return new ResponseEntity<>(getInfo(resourceNotFound, webRequest), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(APIException.class)
    public ResponseEntity<ErrorInfo> handleAPIException(APIException apiException, WebRequest webRequest) {
        return new ResponseEntity<>(getInfo(apiException, webRequest), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationException(MethodArgumentNotValidException exception) {
        Map<String, String> errors = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName, message);
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorInfo> handleGlobalException(Exception exception, WebRequest webRequest) {
        return new ResponseEntity<>(getInfo(exception, webRequest), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    public ErrorInfo getInfo(Exception exception, WebRequest webRequest) {
        ErrorInfo errorInfo = new ErrorInfo(new Date(), exception.getMessage(), webRequest.getDescription(false));
        return errorInfo;
    }
}
