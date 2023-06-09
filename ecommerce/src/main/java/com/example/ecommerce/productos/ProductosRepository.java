package com.example.ecommerce.productos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.ecommerce.productos.proyecciones.ProductoConCategoria;
import com.example.ecommerce.productos.proyecciones.ProductoSinCategoria;

public interface ProductosRepository extends JpaRepository<Producto, Integer>{

    @Query("SELECT p FROM Producto p WHERE p.categoria.id = :categoria")
    List<ProductoSinCategoria> findByCategory(@Param("categoria") int categoria);

    Optional<ProductoSinCategoria> findProductoById(int id);
    
    @Query("SELECT p FROM Producto p JOIN FETCH p.categoria")
    List<Producto> findAllProductosConCategoria();
}
