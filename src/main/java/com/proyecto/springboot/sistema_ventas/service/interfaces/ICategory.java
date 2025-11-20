package com.proyecto.springboot.sistema_ventas.service.interfaces;

import java.util.List;

import com.proyecto.springboot.sistema_ventas.model.dto.request.CategoryRequestDTO;
import com.proyecto.springboot.sistema_ventas.model.dto.response.CategoryResponseDTO;

public interface ICategory {

    CategoryResponseDTO save(CategoryRequestDTO categoryRequest);

    CategoryResponseDTO delete(int id);

    CategoryResponseDTO findById(int id);

    List<CategoryResponseDTO> findAll();

}
