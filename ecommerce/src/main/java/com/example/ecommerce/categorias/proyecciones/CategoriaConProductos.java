package com.example.ecommerce.categorias.proyecciones;

import java.util.List;

import com.example.ecommerce.productos.proyecciones.ProductoSinCategoria;

public interface CategoriaConProductos {

	int getId();
    String getNombre();
    List<ProductoSinCategoria> getProductos();
    
}
