package com.proyecto.springboot.sistema_ventas.model.dto.response;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Data
public class UserResponseDTO {

    private int id;
    private String username;
    private String email;
    private String userType; //Admin, Retail, Wholesale/Retail Customer
}
