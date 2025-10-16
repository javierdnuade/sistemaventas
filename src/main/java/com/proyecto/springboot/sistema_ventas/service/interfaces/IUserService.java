package com.proyecto.springboot.sistema_ventas.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.proyecto.springboot.sistema_ventas.model.dto.request.UserRequestDTO;
import com.proyecto.springboot.sistema_ventas.model.dto.response.UserResponseDTO;

public interface IUserService {

    UserResponseDTO save(UserRequestDTO userRequest);

    Optional<UserResponseDTO> delete(int id);

    List<UserResponseDTO> findAll();
    
    Optional<UserResponseDTO> findById(int id);
}
