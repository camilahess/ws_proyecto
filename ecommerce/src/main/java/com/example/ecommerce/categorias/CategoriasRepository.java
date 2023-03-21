package com.example.ecommerce.categorias;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.ecommerce.categorias.proyecciones.CategoriaConProductos;
import com.example.ecommerce.categorias.proyecciones.CategoriaSinProductos;



public interface CategoriasRepository extends JpaRepository<Categoria, Integer> {

    List<CategoriaConProductos> findByNombreContaining(String nombre);

    // Devuelve todas las categorías
    List<CategoriaSinProductos> findBy();

    Optional<CategoriaConProductos> findCategoryById(int id);
	
}
