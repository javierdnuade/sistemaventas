package com.proyecto.springboot.sistema_ventas.exceptions;

public class ConflictException extends BasedException {

    public ConflictException(String code, String message) {
        super(code, message);
    }

    public static ConflictException userAlreadyExists(String email, String username) {
        return new ConflictException("P-300-USER_ALREADY_EXISTS", "El usuario ya existe. Cambia el email o el username");
    }

    public static ConflictException productAlreadyExists(String name) {
        return new ConflictException("P-301-PRODUCT_ALREADY_EXISTS", "El producto ya existe. Cambia el nombre");
    }

}