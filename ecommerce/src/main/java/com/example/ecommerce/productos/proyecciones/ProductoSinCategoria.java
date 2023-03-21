package com.example.ecommerce.productos.proyecciones;

import org.springframework.beans.factory.annotation.Value;

//Proyección para que el repository pueda devolver un producto sin categoría asociada
public interface ProductoSinCategoria {
	int getId();
	String getImagen();
    String getNombre();
    String getDescripcion();
    double getPrecio();

    // Campo calculado (no está en Product) con el id de la categoría
    @Value("#{target.categoria.id}")
    int getIdCategoria();
	

}
