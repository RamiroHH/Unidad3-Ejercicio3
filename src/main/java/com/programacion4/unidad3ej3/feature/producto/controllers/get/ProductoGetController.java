package com.programacion4.unidad3ej3.feature.producto.controllers.get;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import com.programacion4.unidad3ej3.feature.producto.dtos.response.ProductoResponseDto;
import com.programacion4.unidad3ej3.feature.producto.services.interfaces.domain.IProductoGetAllService;
import com.programacion4.unidad3ej3.feature.producto.services.interfaces.domain.IProductoGetByIdService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class ProductoGetController {

    private final IProductoGetAllService productoGetAllService;
    private final IProductoGetByIdService productoGetByIdService;

    @GetMapping("/productos")
    public ResponseEntity<List<ProductoResponseDto>> getAll() {
        return ResponseEntity.ok(productoGetAllService.getAll());
    }

    @GetMapping("/productos/{id}")
    public ResponseEntity<ProductoResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(productoGetByIdService.getById(id));
    }
}