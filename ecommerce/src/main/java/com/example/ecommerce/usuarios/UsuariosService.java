package com.example.ecommerce.usuarios;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.ecommerce.auth.dto.LoginDto;

@Service
public class UsuariosService {
	@Autowired
    private UsuariosRepository usuariosRepository;

    List<Usuario> getAll() {
        return (List<Usuario>) usuariosRepository.findAll();
    }

    public Usuario login(LoginDto loginDto) throws NoSuchAlgorithmException {
        return usuariosRepository.findByCorreoAndPassword(loginDto.getCorreo(), encodePassword(loginDto.getPassword()))
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Correo y/o contraseña no válidos"));
    }

    public Usuario insert(Usuario u) throws NoSuchAlgorithmException {
        u.setPassword(encodePassword(u.getPassword()));
        return usuariosRepository.save(u);
    }

    public void delete(int idUsuario) {
        usuariosRepository.deleteById(idUsuario);
    }

    private String encodePassword(String pass) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(pass.getBytes(StandardCharsets.UTF_8));
        String encodedPass = Base64.getEncoder().encodeToString(hash);
        return encodedPass;
    }

}
