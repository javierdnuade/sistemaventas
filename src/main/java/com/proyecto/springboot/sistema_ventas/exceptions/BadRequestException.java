package com.proyecto.springboot.sistema_ventas.exceptions;

import org.springframework.http.HttpStatus;

public class BadRequestException extends BasedException {

    public BadRequestException(String code, String message) {
        super(code, message, HttpStatus.BAD_REQUEST);
    }

    public static BadRequestException invalidRequest() {
        return new BadRequestException("P-100-BAD_REQUEST", "Request body is null");
    }
}
