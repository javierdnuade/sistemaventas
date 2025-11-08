package com.proyecto.springboot.sistema_ventas.controller;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.proyecto.springboot.sistema_ventas.exceptions.BasedException;
import com.proyecto.springboot.sistema_ventas.model.dto.response.ErrorDTO;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BasedException.class)
    public ResponseEntity<ErrorDTO> handleBasedException(BasedException ex, HttpServletRequest request) {
        ErrorDTO error = ErrorDTO.builder()
            .code(ex.getCode())
            .message(ex.getMessage())
            .path(request.getRequestURI())
            .timestamp(LocalDateTime.now())
            .statusHttp(ex.getStatus().value())
            .build();
        return ResponseEntity.status(ex.getStatus()).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTO> handleValidation(MethodArgumentNotValidException ex, HttpServletRequest request) {
        String details = ex.getBindingResult().getFieldErrors().stream()
            .map(f -> f.getField() + ": " + f.getDefaultMessage())
            .collect(Collectors.joining("; "));
        ErrorDTO err = ErrorDTO.builder()
            .code("P-102-VALIDATION_FAILED")
            .message(details)
            .path(request.getRequestURI())
            .timestamp(LocalDateTime.now())
            .statusHttp(ex.getStatusCode().value())
            .build();
        return ResponseEntity.status(ex.getStatusCode()).body(err);
    }
    
}
