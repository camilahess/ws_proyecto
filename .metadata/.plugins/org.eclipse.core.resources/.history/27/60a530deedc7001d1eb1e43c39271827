package com.example.ecommerce.categorias;

import java.util.List;

import com.example.ecommerce.productos.Producto;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@Table(name = "categoria")
public class Categoria {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	@Column(nullable = false)
    private String nombre;
    
	@JsonIgnore
    @OneToMany(mappedBy = "categoria", cascade = CascadeType.PERSIST)
    private List<Producto> productos;

//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getNombre() {
//		return nombre;
//	}
//
//	public void setNombre(String nombre) {
//		this.nombre = nombre;
//	}
//
//	public List<Producto> getProductos() {
//		return productos;
//	}
//
//	public void setProductos(List<Producto> productos) {
//		this.productos = productos;
//	}
//    
    
    

}
