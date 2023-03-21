package com.example.ecommerce.productos.proyecciones;

import com.example.ecommerce.categorias.proyecciones.CategoriaConProductos;

public interface ProductoConCategoria {

	int getId();
	String getImagen();
    String getNombre();
    String getDescripcion();
    double getPrecio();
    CategoriaConProductos getCategoria();
}
