package com.proyecto.springboot.sistema_ventas.service.interfaces;

import java.util.List;

import com.proyecto.springboot.sistema_ventas.model.dto.request.AdminRequestDTO;
import com.proyecto.springboot.sistema_ventas.model.dto.response.AdminResponseDTO;

public interface IAdminService {

    AdminResponseDTO save(AdminRequestDTO adminRequest);

    AdminResponseDTO delete(int id);

    AdminResponseDTO findById(int id);

    List<AdminResponseDTO> findAll();

}
