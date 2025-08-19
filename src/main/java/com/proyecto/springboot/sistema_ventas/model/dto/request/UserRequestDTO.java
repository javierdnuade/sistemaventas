package com.proyecto.springboot.sistema_ventas.model.dto.request;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.experimental.SuperBuilder;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
    @JsonSubTypes.Type(value = AdminRequestDTO.class, name = "ADMIN"),
    @JsonSubTypes.Type(value = WholesaleCustomerRequestDTO.class, name = "WHOLESALE"),
    @JsonSubTypes.Type(value = RetailCustomerRequestDTO.class, name = "RETAIL")

})
@Data
@SuperBuilder
public abstract class UserRequestDTO {

    @NotBlank
    @Size(min = 4, max = 60, message = "El nombre de usuario debe tener entre 4 y 60 caracteres")
    private String username;

    @NotBlank
    @Size(min = 8, max = 60, message = "La contraseña debe tener entre 6 y 60 caracteres")
    private String password;

    @NotBlank
    @Email(message = "El email debe ser válido y no puede estar vacio")
    private String email;
}
