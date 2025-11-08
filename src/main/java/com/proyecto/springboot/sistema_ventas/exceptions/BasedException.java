package com.proyecto.springboot.sistema_ventas.exceptions;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public abstract class BasedException extends RuntimeException {
    
    private final HttpStatus status;
    private final String code;

    // Excepcion para manejar los errores personalizados
    public BasedException(String code, String message, HttpStatus status) {
        super(message);
        this.code = code;
        this.status = status;
    }
}
