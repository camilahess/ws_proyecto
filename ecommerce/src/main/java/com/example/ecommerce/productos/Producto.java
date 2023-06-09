package com.example.ecommerce.productos;

import com.example.ecommerce.categorias.Categoria;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@Table(name = "producto")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String imagen;
	@Column(nullable = false)
	private String nombre;
	private String descripcion;
	private Double precio;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "categoria")
	private Categoria categoria; // Nombre de la columna con la clave ajena

//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getImagen() {
//		return imagen;
//	}
//
//	public void setImagen(String rutaImagen) {
//		this.imagen = rutaImagen;
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
//	public String getDescripcion() {
//		return descripcion;
//	}
//
//	public void setDescripcion(String descripcion) {
//		this.descripcion = descripcion;
//	}
//
//	public Double getPrecio() {
//		return precio;
//	}
//
//	public void setPrecio(Double precio) {
//		this.precio = precio;
//	}
//
//	public Categoria getCategoria() {
//		return categoria;
//	}
//
//	public void setCategoria(Categoria categoria) {
//		this.categoria = categoria;
//	}
//	
	
}
