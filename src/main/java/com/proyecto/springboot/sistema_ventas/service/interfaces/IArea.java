package com.proyecto.springboot.sistema_ventas.service.interfaces;

import java.util.List;

import com.proyecto.springboot.sistema_ventas.model.dto.request.AreaRequestDTO;
import com.proyecto.springboot.sistema_ventas.model.dto.response.AreaResponseDTO;

public interface IArea {

    AreaResponseDTO save(AreaRequestDTO areaRequest);

    AreaResponseDTO delete(int id);

    List<AreaResponseDTO> findAll();

    AreaResponseDTO findById(int id);
}
