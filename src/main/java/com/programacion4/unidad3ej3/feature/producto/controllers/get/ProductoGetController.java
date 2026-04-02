package com.programacion4.unidad3ej3.feature.producto.controllers.get;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.*;

import com.programacion4.unidad3ej3.feature.producto.dtos.request.ProductoCreateRequestDto;
import com.programacion4.unidad3ej3.feature.producto.dtos.request.ProductoPatchRequestDto;
import com.programacion4.unidad3ej3.feature.producto.dtos.response.ProductoResponseDto;
import com.programacion4.unidad3ej3.feature.producto.services.interfaces.domain.IProductoGetAllService;
import com.programacion4.unidad3ej3.feature.producto.services.interfaces.domain.IProductoGetByIdService;
import com.programacion4.unidad3ej3.feature.producto.services.interfaces.domain.IProductoUpdateService;
import com.programacion4.unidad3ej3.feature.producto.services.interfaces.domain.IProductoPatchService;
import com.programacion4.unidad3ej3.feature.producto.services.interfaces.domain.IProductoDeleteService;
import org.springframework.http.ResponseEntity;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class ProductoGetController {

    private final IProductoGetAllService productoGetAllService;
    private final IProductoGetByIdService productoGetByIdService;
    private final IProductoUpdateService productoUpdateService;
    private final IProductoPatchService productoPatchService;
    private final IProductoDeleteService productoDeleteService;

    @GetMapping("/productos")
    public ResponseEntity<List<ProductoResponseDto>> getAll() {
        return ResponseEntity.ok(productoGetAllService.getAll());
    }

    @GetMapping("/productos/{id}")
    public ResponseEntity<ProductoResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(productoGetByIdService.getById(id));
    }

    @PutMapping("/productos/{id}")
    public ResponseEntity<ProductoResponseDto> update(
            @PathVariable Long id,
            @RequestBody ProductoCreateRequestDto dto) {

        return ResponseEntity.ok(productoUpdateService.update(id, dto));
    }

    @PatchMapping("/productos/{id}")
    public ResponseEntity<ProductoResponseDto> patch(
            @PathVariable Long id,
            @RequestBody ProductoPatchRequestDto dto) {

        return ResponseEntity.ok(productoPatchService.patch(id, dto));
    }

    @DeleteMapping("/productos/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        productoDeleteService.delete(id);

        return ResponseEntity.noContent().build();
    }
}