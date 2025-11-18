package com.proyecto.springboot.sistema_ventas.model.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@NoArgsConstructor
@SuperBuilder
@Data
public class UserResponseDTO {

    private String username;
    private String email;
    private String userType; //Admin, Retail, Wholesale/Retail Customer
}
