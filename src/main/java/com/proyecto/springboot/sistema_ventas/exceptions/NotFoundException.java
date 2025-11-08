package com.proyecto.springboot.sistema_ventas.exceptions;

import org.springframework.http.HttpStatus;

public class NotFoundException extends BasedException {

    public NotFoundException(String code, String message) {
        super(code, message, HttpStatus.NOT_FOUND);
    }

    public static NotFoundException userNotFound() {
        return new NotFoundException("P-400-USER_NOT_FOUND", "Usuario no encontrado");
    }

    public static NotFoundException productNotFound() {
        return new NotFoundException("P-401-PRODUCT_NOT_FOUND", "Producto no encontrado");
    }

    public static NotFoundException categoryNotFound() {
        return new NotFoundException("P-402-CATEGORY_NOT_FOUND", "Categoría no encontrada");
    }

    public static NotFoundException areaNotFound() {
        return new NotFoundException("P-403-AREA_NOT_FOUND", "Área no encontrada");
    }

    public static NotFoundException invoiceNotFound() {
        return new NotFoundException("P-404-INVOICE_NOT_FOUND", "Factura no encontrada");
    }
}
