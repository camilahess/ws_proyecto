package com.example.ecommerce.usuarios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuariosRepository extends JpaRepository<Usuario, Integer>{
	 Optional<Usuario> findByCorreoAndPassword(String correo, String password);

}
