package com.proyecto.springboot.sistema_ventas.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.springboot.sistema_ventas.exceptions.BadRequestException;
import com.proyecto.springboot.sistema_ventas.exceptions.ConflictException;
import com.proyecto.springboot.sistema_ventas.exceptions.NotFoundException;
import com.proyecto.springboot.sistema_ventas.model.dto.request.CategoryRequestDTO;
import com.proyecto.springboot.sistema_ventas.model.dto.response.CategoryResponseDTO;
import com.proyecto.springboot.sistema_ventas.model.entity.Category;
import com.proyecto.springboot.sistema_ventas.repository.CategoryRepository;
import com.proyecto.springboot.sistema_ventas.service.interfaces.ICategory;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements ICategory {

    private final CategoryRepository repository;

    @Transactional
    @Override
    public CategoryResponseDTO save(CategoryRequestDTO categoryRequest) {
        if (categoryRequest == null) throw BadRequestException.invalidRequest();
        if (repository.existsByName(categoryRequest.getName())) throw ConflictException.categoryAlreadyExists(categoryRequest.getName());

        Category category = Category.builder()
            .name(categoryRequest.getName())
            .description(categoryRequest.getDescription())
            .build();
        
        repository.save(category);
        return CategoryResponseDTO.builder()
            .name(categoryRequest.getName())
            .description(categoryRequest.getDescription())
            .build();
    }

    @Transactional
    @Override
    public CategoryResponseDTO delete(int id) {
        Category category = repository.findById(id)
            .orElseThrow( () -> NotFoundException.categoryNotFound(id));

        repository.deleteById(id);
        return CategoryResponseDTO.builder()
            .name(category.getName())
            .description(category.getDescription())
            .build();
    }

    @Transactional(readOnly = true)
    @Override
    public CategoryResponseDTO findById(int id) {
        Category category = repository.findById(id)
            .orElseThrow( () -> NotFoundException.categoryNotFound(id));

        return CategoryResponseDTO.builder()
            .name(category.getName())
            .description(category.getDescription())
            .build();
    }

    @Transactional (readOnly = true)
    @Override
    public List<CategoryResponseDTO> findAll() {
        return repository.findAll().stream().map( category -> 
            CategoryResponseDTO.builder()
                .name(category.getName())
                .description(category.getDescription())
                .build()
        )
        .collect(Collectors.toList());
    }
}
