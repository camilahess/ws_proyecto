package com.example.ecommerce.productos;


import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.ecommerce.categorias.Categoria;
import com.example.ecommerce.categorias.CategoriasRepository;
import com.example.ecommerce.productos.proyecciones.ProductoConCategoria;
import com.example.ecommerce.productos.proyecciones.ProductoSinCategoria;

import lombok.RequiredArgsConstructor;



@Service
@RequiredArgsConstructor
public class ProductosService {

	@Autowired
    private ProductosRepository produRepository;
	
	@Autowired
    private CategoriasRepository catRepository;

        
    public List<ProductoSinCategoria> getProductos(int idCat) {
        return produRepository.findByCategory(idCat);
    }

    public ProductoSinCategoria getProducto(int id) {
        return produRepository.findProductoById(id).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado")
        );
    }

    public Producto insertProducto(Producto p, int idCat) {
        Categoria c = catRepository.findById(idCat).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria no encontrada")
        );
        c.setProductos(null);
        p.setCategoria(c);
        return produRepository.save(p);
    }


    
    //-------------------------------------------------------- MODIFICAR PRODUCTO
//    public Producto updateProducto(Producto p) {
//        Producto pActualizado = produRepository.findById(p.getId()).orElseThrow(
//            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado")
//        );
//
//        // Actualizar los campos del producto
//        if (p.getNombre() != null) {
//        	pActualizado.setNombre(p.getNombre());
//        }
//        if (p.getDescripcion() != null) {
//        	pActualizado.setDescripcion(p.getDescripcion());
//        }
//        if (p.getPrecio() != null) {
//        	pActualizado.setPrecio(p.getPrecio());
//        }
//        if (p.getCategoria() != null) {
//        	pActualizado.setCategoria(p.getCategoria());
//        }
//
//        return produRepository.save(pActualizado);
//    }
    
    //-------------------------------------------------------- MODIFICAR PRODUCTO CON BEAN UTILS (?
    public Producto updateProducto(Producto p) {
        Producto pActualizado = produRepository.findById(p.getId()).orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado")
        );
        // Actualizar los campos del producto
        BeanUtils.copyProperties(p, pActualizado, "id");
        return produRepository.save(pActualizado);
    }
    /*<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-beans</artifactId>
    <version>5.3.15</version>
</dependency>

import org.springframework.beans.BeanUtils;

public Producto updateProducto(Producto p) {
    Producto pActualizado = produRepository.findById(p.getId()).orElseThrow(
        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado")
    );

    // Actualizar los campos del producto
    BeanUtils.copyProperties(p, pActualizado, "id");

    return produRepository.save(pActualizado);
}

*Con esta implementación, BeanUtils.copyProperties() copiará automáticamente las propiedades de p a pActualizado,
* excepto por la propiedad id, que se debe mantener la misma. De esta manera,
no es necesario verificar cada campo individualmente con if.
*
*
*/
    
    
    
    public void deleteProducto(int id) {
        produRepository.deleteById(id);
    }
    
    
}
