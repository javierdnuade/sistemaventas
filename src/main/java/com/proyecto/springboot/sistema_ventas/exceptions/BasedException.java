package com.proyecto.springboot.sistema_ventas.exceptions;

import lombok.Getter;

@Getter
public abstract class BasedException extends RuntimeException {

    private final String code;
    private final String message;

    public BasedException(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
