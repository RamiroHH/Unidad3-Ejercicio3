package com.programacion4.unidad3ej3.feature.producto.services.impl.domain;

import org.springframework.stereotype.Service;

import com.programacion4.unidad3ej3.config.exceptions.NotFoundException;
import com.programacion4.unidad3ej3.feature.producto.dtos.response.ProductoResponseDto;
import com.programacion4.unidad3ej3.feature.producto.mappers.ProductoMapper;
import com.programacion4.unidad3ej3.feature.producto.models.Producto;
import com.programacion4.unidad3ej3.feature.producto.repositories.IProductoRepository;
import com.programacion4.unidad3ej3.feature.producto.services.interfaces.domain.IProductoGetByIdService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductoGetByIdService implements IProductoGetByIdService {

    private final IProductoRepository productoRepository;

    @Override
    public ProductoResponseDto getById(Long id) {

        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Producto no encontrado"));

        return ProductoMapper.toResponseDto(producto);
    }
}