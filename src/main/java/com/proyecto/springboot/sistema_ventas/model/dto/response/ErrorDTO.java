package com.proyecto.springboot.sistema_ventas.model.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class ErrorDTO {

    private String code;
    private String message;
    private String path;
    private String timestamp;  
    private int statusHttp;       

}
