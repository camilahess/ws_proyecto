package com.example.ecommerce.productos;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.ecommerce.productos.proyecciones.ProductoConCategoria;
import com.example.ecommerce.productos.proyecciones.ProductoSinCategoria;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;



@RestController
@RequestMapping("/productos")
@CrossOrigin(origins = "*") // agregamos crossorigin para acceder desde el front http://localhost:4200
public class ProductosController {

	@Autowired
    private ProductosService produService;
	@Autowired
	private ProductosRepository produRepository;

	// ---------------------------------------------- LISTAR TODOS LAS PRODUCTOS CON CATEGORIA
	@GetMapping
    public List<Producto> getProductos() {
        return produRepository.findAllProductosConCategoria();
    }

//    @GetMapping
//    public List<ProductoSinCategoria> getProductos(@RequestParam int categoria) {
//        return produService.getProductos(categoria);
//    }
	// ---------------------------------------------- OBTENER PRODUCTO CON CATEGORIA POR ID PRODUCTO
    @GetMapping("/{id}")
    public ProductoSinCategoria getProducto(@PathVariable int id) {
        return produService.getProducto(id);
    }
    

    // ---------------------------------------------- INSERTAR PRODUCTO EN CATEGORÍA
	@PostMapping("/{idCat}")
	@ResponseStatus(HttpStatus.CREATED)
	public Producto insertProducto(@RequestBody Producto p, @PathVariable int idCat) {
		return produService.insertProducto(p, idCat);
	}
	

	 //----------------------------------------------- MODIFICAR PRODUCTO
	@PutMapping("/{id}")
	public Producto updateProducto(@PathVariable int id, @RequestBody Producto p) {
	    p.setId(id);
	    return produService.updateProducto(p);
	}

    @DeleteMapping("/{idProd}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProducto(@PathVariable int idProd) {
        produService.deleteProducto(idProd);
    }
    

	// Borra un producto de una categoría
	@DeleteMapping("/{idCat}/productos/{idProd}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteProduct(@PathVariable int idProd) {
		produService.deleteProducto(idProd);
	}
}
