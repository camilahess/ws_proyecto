package com.example.ecommerce.categorias;

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

import com.example.ecommerce.categorias.proyecciones.CategoriaConProductos;
import com.example.ecommerce.categorias.proyecciones.CategoriaSinProductos;
import com.example.ecommerce.productos.Producto;
import com.example.ecommerce.productos.ProductosService;
import com.example.ecommerce.productos.proyecciones.ProductoSinCategoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/categorias")
@CrossOrigin(origins = "*") // agregamos crossorigin para acceder desde el front
public class CategoriasController {

	@Autowired
	private CategoriasService catService;
	@Autowired
	private ProductosService produService;

	// ---------------------------------------------- LISTAR TODAS LAS CATEGORÍAS SIN PRODUCTO
	@GetMapping
	public List<CategoriaSinProductos> getCategorias(@RequestParam(required = false) String nombre) {
		return catService.getCategorias();
	}

	// ---------------------------------------------- LISTAR CATEGORÍA CON SUS PRODUCTOS POR NOMBRE DE CATEGORÍA
	@GetMapping("/{nombre}")
	public List<CategoriaConProductos> getCategoria(@PathVariable String nombre) {

		return catService.getCategoriasPorNombre(nombre);
	}

	// ---------------------------------------------- INSERTAR CATEGORIA
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Categoria insertCategoria(@RequestBody Categoria c) {
		return catService.insert(c);
	}

	// ---------------------------------------------- MODIFICAR CATEGORIA POR ID
	@PutMapping("/{id}")
	public Categoria updateCategoria(@RequestBody Categoria c, @PathVariable int id) {
		return catService.update(c, id);
	}

	// ---------------------------------------------- ELIMINAR CATEGORIA POR ID
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCategoria(@PathVariable int id) {
		catService.delete(id);
	}

//	// Devuelve todos los productos de una categoría
//	@GetMapping("/{idCat}/productos")
//	public List<ProductoSinCategoria> getProductos(@PathVariable int idCat) {
//		return produService.getProductos(idCat);
//	}


}
