package com.example.ecommerce.usuarios;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.example.ecommerce.usuarios.dto.UsuarioInsertDto;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/usuario")
public class UsuariosController {
	
	@Autowired
    private UsuariosService usuariosService;

    @GetMapping
    public List<Usuario> getAll() {
            return usuariosService.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario insert(@RequestBody @Valid UsuarioInsertDto dto)  throws NoSuchAlgorithmException {
        return usuariosService.insert(new Usuario(dto));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        usuariosService.delete(id);
    }
}