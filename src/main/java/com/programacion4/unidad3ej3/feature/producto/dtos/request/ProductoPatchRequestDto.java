package com.programacion4.unidad3ej3.feature.producto.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductoPatchRequestDto {

    private Double precio;
    private Integer stock;
}