package com.programacion4.unidad3ej3.feature.producto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.programacion4.unidad3ej3.feature.producto.models.Producto;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Long> {

    boolean existsByNombre(String nombre);
    
}
