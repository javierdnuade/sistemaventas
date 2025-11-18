package com.proyecto.springboot.sistema_ventas.service.interfaces;

import java.util.List;
import java.util.Optional;

import com.proyecto.springboot.sistema_ventas.model.dto.request.AdminRequestDTO;
import com.proyecto.springboot.sistema_ventas.model.dto.response.AdminResponseDTO;

public interface IAdminService {

    AdminResponseDTO save(AdminRequestDTO adminRequest);

    Optional<AdminResponseDTO> delete(int id);

    Optional<AdminResponseDTO> findById(int id);

    List<AdminResponseDTO> findAll();

}
