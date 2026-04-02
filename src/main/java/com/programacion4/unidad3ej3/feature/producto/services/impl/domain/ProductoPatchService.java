package com.programacion4.unidad3ej3.feature.producto.services.impl.domain;

import org.springframework.stereotype.Service;

import com.programacion4.unidad3ej3.config.exceptions.NotFoundException;
import com.programacion4.unidad3ej3.feature.producto.dtos.request.ProductoPatchRequestDto;
import com.programacion4.unidad3ej3.feature.producto.dtos.response.ProductoResponseDto;
import com.programacion4.unidad3ej3.feature.producto.mappers.ProductoMapper;
import com.programacion4.unidad3ej3.feature.producto.models.Producto;
import com.programacion4.unidad3ej3.feature.producto.repositories.IProductoRepository;
import com.programacion4.unidad3ej3.feature.producto.services.interfaces.domain.IProductoPatchService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductoPatchService implements IProductoPatchService {

    private final IProductoRepository productoRepository;

    @Override
    public ProductoResponseDto patch(Long id, ProductoPatchRequestDto dto) {

        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Producto no encontrado"));

        // 🔥 SOLO actualiza si viene el dato
        if (dto.getPrecio() != null) {
            producto.setPrecio(dto.getPrecio());
        }

        if (dto.getStock() != null) {
            producto.setStock(dto.getStock());
        }

        Producto actualizado = productoRepository.save(producto);

        return ProductoMapper.toResponseDto(actualizado);
    }
}