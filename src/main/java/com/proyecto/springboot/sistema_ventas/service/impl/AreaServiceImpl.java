package com.proyecto.springboot.sistema_ventas.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.springboot.sistema_ventas.exceptions.BadRequestException;
import com.proyecto.springboot.sistema_ventas.exceptions.ConflictException;
import com.proyecto.springboot.sistema_ventas.exceptions.NotFoundException;
import com.proyecto.springboot.sistema_ventas.model.dto.request.AreaRequestDTO;
import com.proyecto.springboot.sistema_ventas.model.dto.response.AreaResponseDTO;
import com.proyecto.springboot.sistema_ventas.model.entity.Area;
import com.proyecto.springboot.sistema_ventas.repository.AreaRepository;
import com.proyecto.springboot.sistema_ventas.service.interfaces.IArea;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class AreaServiceImpl implements IArea {

    private final AreaRepository repository;

    @Transactional
    @Override
    public AreaResponseDTO save(AreaRequestDTO areaRequest) {
        if (areaRequest == null) {
            throw BadRequestException.invalidRequest();
        }

        if (repository.existsByName(areaRequest.getName())) {
            throw ConflictException.areaAlreadyExists(areaRequest.getName());
        }
        
        Area area = new Area(areaRequest.getName());
        repository.save(area);
        return AreaResponseDTO.builder()
            .name(area.getName())
            .build();
    }

    @Transactional
    @Override
    public AreaResponseDTO delete(int id) {
        Area area = repository.findById(id)
            .orElseThrow( () -> NotFoundException.areaNotFound(id));
        
        repository.deleteById(id);
        return AreaResponseDTO.builder()
            .name(area.getName())
            .build();
    }

    @Transactional(readOnly = true)
    @Override
    public List<AreaResponseDTO> findAll() {
        return repository.findAll().stream().map(area ->
            AreaResponseDTO.builder()
                .name(area.getName())
                .build()
        )
        .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public AreaResponseDTO findById(int id) {
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

}
