package com.example.ecommerce.usuarios;

import com.example.ecommerce.usuarios.dto.UsuarioInsertDto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Usuario {

    @Id
    private int id;
    private String correo;
    private String password;

    public Usuario(UsuarioInsertDto dto) {
        this.correo = dto.getCorreo();
        this.password = dto.getPassword();
    }
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getCorreo() {
//		return correo;
//	}
//
//	public void setCorreo(String correo) {
//		this.correo = correo;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public Usuario(int id, String correo, String password) {
//		super();
//		this.id = id;
//		this.correo = correo;
//		this.password = password;
//	}
//	public Usuario() {
//		super();
//	
//	}
    
    
}
