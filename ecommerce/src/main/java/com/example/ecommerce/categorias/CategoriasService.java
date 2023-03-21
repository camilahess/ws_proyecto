package com.example.ecommerce.categorias;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.ecommerce.categorias.proyecciones.CategoriaConProductos;
import com.example.ecommerce.categorias.proyecciones.CategoriaSinProductos;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class CategoriasService {

	@Autowired
	 private CategoriasRepository catRepository;
	 

	    public List<CategoriaSinProductos> getCategorias() {
	        return catRepository.findBy();
	    }

//	    public List<Categoria> getAll() {
//	        return catRepository.findAll();
//	    }
	    
	    public List<CategoriaConProductos> getCategoriasPorNombre(String nombre) {
	        // return catRepository.getByName("%" + name + "%");
	        return catRepository.findByNombreContaining(nombre);
	    }

	    public CategoriaConProductos getCategoria(int id) {
	        return catRepository.findCategoryById(id).orElseThrow(
	            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria no encontrada")
	        );
	    }

	    public Categoria insert(Categoria c) {
	        c.setId(0); // Por si acaso nos envían una id (haría un update en lugar de insert)
	        return catRepository.save(c);
	    }

	    public Categoria update(Categoria c, int id) {
	        if(!catRepository.existsById(id)) {
	            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Categoria no encontrada", null);
	        }
	        c.setId(id); // Al tener una id hace un update en lugar de un insert
	        return catRepository.save(c);
	    }

	    public void delete(int id) {
	        catRepository.deleteById(id);
	    }
	 
}

