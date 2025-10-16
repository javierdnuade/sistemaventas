package com.proyecto.springboot.sistema_ventas.service.impl;

import java.util.List;
import java.util.Optional;

import com.proyecto.springboot.sistema_ventas.model.dto.request.UserRequestDTO;
import com.proyecto.springboot.sistema_ventas.model.dto.response.UserResponseDTO;
import com.proyecto.springboot.sistema_ventas.service.interfaces.IUserService;

public class AdminService implements IUserService {

    @Override
    public UserResponseDTO save(UserRequestDTO userRequest) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public Optional<UserResponseDTO> delete(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public List<UserResponseDTO> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Optional<UserResponseDTO> findById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

}
