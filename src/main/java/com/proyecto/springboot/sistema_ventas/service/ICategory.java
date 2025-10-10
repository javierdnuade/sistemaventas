package com.proyecto.springboot.sistema_ventas.service;

import java.util.List;
import java.util.Optional;

import com.proyecto.springboot.sistema_ventas.model.dto.request.CategoryRequestDTO;
import com.proyecto.springboot.sistema_ventas.model.dto.response.CategoryResponseDTO;

public interface ICategory {

    CategoryResponseDTO save(CategoryRequestDTO categoryRequest);

    Optional<CategoryResponseDTO> delete(int id);

    Optional<CategoryResponseDTO> findById(int id);

    List<CategoryResponseDTO> findAll();

}
