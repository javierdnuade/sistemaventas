package com.proyecto.springboot.sistema_ventas.exceptions;

import org.springframework.http.HttpStatus;

public class ConflictException extends BasedException {

    public ConflictException(String code, String message) {
        super(code, message, HttpStatus.CONFLICT);
    }

    public static ConflictException userAlreadyExists() {
        return new ConflictException("P-300-USER_ALREADY_EXISTS",
        "El usuario ya existe. Cambia el email o el username");
    }

    public static ConflictException productAlreadyExists(String name) {
        return new ConflictException("P-301-PRODUCT_ALREADY_EXISTS",
        "El producto '" + name + "' ya existe. Cambia el nombre");
    }

    public static ConflictException categoryAlreadyExists(String name) {
        return new ConflictException("P-302-CATEGORY_ALREADY_EXISTS",
        "La categoría '" + name + "' ya existe. Cambia el nombre");
    }

    public static ConflictException areaAlreadyExists(String name) {
        return new ConflictException("P-303-AREA_ALREADY_EXISTS",
        "El area '" + name + "' ya existe. Cambia el nombre");
    }

    public static ConflictException productNoStock(int productId) {
        return new ConflictException("P-304-INSUFFICIENT_STOCK",
            "Stock insuficiente para el producto id: " + productId);
    }
}