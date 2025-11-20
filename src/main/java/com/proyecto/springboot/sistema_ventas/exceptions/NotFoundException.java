package com.proyecto.springboot.sistema_ventas.exceptions;

import org.springframework.http.HttpStatus;

public class NotFoundException extends BasedException {

    public NotFoundException(String code, String message) {
        super(code, message, HttpStatus.NOT_FOUND);
    }

    public static NotFoundException userNotFound(int id) {
        return new NotFoundException("P-400-USER_NOT_FOUND", "Usuario con id '" + id +  "'' no encontrado");
    }

    public static NotFoundException productNotFound(int id) {
        return new NotFoundException("P-401-PRODUCT_NOT_FOUND", "Producto con id '" + id + "' encontrado");
    }

    public static NotFoundException categoryNotFound(int id) {
        return new NotFoundException("P-402-CATEGORY_NOT_FOUND", "Categoría con id '" + id + "' encontrada");
    }

    public static NotFoundException areaNotFound(int id) {
        return new NotFoundException("P-403-AREA_NOT_FOUND", "Área con id '" + id + "' encontrada");
    }

    public static NotFoundException invoiceNotFound(int id) {
        return new NotFoundException("P-404-INVOICE_NOT_FOUND", "Factura con id '" + id + "' encontrada");
    }
}
