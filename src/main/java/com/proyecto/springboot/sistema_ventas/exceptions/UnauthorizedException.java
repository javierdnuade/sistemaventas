package com.proyecto.springboot.sistema_ventas.exceptions;

import org.springframework.http.HttpStatus;

public class UnauthorizedException extends BasedException {

    public UnauthorizedException(String code, String message) {
        super(code, message, HttpStatus.UNAUTHORIZED);
    }

    public static UnauthorizedException invalidCredentials() {
        return new UnauthorizedException("P-501-INVALID_CREDENTIALS",
        "Acceso solo para administradores o credenciales inválidas");
    }

}
