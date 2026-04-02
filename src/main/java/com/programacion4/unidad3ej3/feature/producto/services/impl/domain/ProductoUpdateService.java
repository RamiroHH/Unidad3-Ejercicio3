package com.programacion4.unidad3ej3.feature.producto.services.impl.domain;

import org.springframework.stereotype.Service;

import com.programacion4.unidad3ej3.config.exceptions.NotFoundException;
import com.programacion4.unidad3ej3.feature.producto.dtos.request.ProductoCreateRequestDto;
import com.programacion4.unidad3ej3.feature.producto.dtos.response.ProductoResponseDto;
import com.programacion4.unidad3ej3.feature.producto.mappers.ProductoMapper;
import com.programacion4.unidad3ej3.feature.producto.models.Producto;
import com.programacion4.unidad3ej3.feature.producto.repositories.IProductoRepository;
import com.programacion4.unidad3ej3.feature.producto.services.interfaces.domain.IProductoUpdateService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductoUpdateService implements IProductoUpdateService {

    private final IProductoRepository productoRepository;

    @Override
    public ProductoResponseDto update(Long id, ProductoCreateRequestDto dto) {

        // 🔍 Buscar producto
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Producto no encontrado"));

        // 🧠 Validación simple
        if (dto.getNombre() == null || dto.getDescripcion() == null) {
            throw new RuntimeException("Campos obligatorios faltantes");
        }

        // 🔄 Actualizar campos
        producto.setNombre(dto.getNombre());
        producto.setDescripcion(dto.getDescripcion());
        producto.setPrecio(dto.getPrecio());
        producto.setStock(dto.getStock());

        // 💾 Guardar cambios
        Producto actualizado = productoRepository.save(producto);

        // 🔁 Convertir a DTO
        return ProductoMapper.toResponseDto(actualizado);
    }
}