package com.example.ecommerce.auth;

import java.security.NoSuchAlgorithmException;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.ecommerce.auth.dto.LoginDto;
import com.example.ecommerce.auth.dto.RespuestaTokenDto;
import com.example.ecommerce.usuarios.Usuario;
import com.example.ecommerce.usuarios.UsuariosService;
import com.example.ecommerce.usuarios.dto.UsuarioInsertDto;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;


@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController { 

	@Autowired
    private UsuariosService usuariosService;

    @PostMapping("/login")
    public RespuestaTokenDto login(@RequestBody LoginDto loginDto) throws NoSuchAlgorithmException {
        Usuario u = usuariosService.login(loginDto);
        String token = getToken(u);
        return new RespuestaTokenDto(token);
    }

    @PostMapping("/registro")
    @ResponseStatus(HttpStatus.CREATED)
    public void registro(@RequestBody UsuarioInsertDto userDto) throws NoSuchAlgorithmException {
        usuariosService.insert(new Usuario(userDto));
    }

    private String getToken(Usuario user) {
        Algorithm algorithm = Algorithm.HMAC256("token100");
        String token = JWT.create()
                .withIssuer("camilahess")
                .withClaim("id", user.getId())
                .withIssuedAt(new Date(System.currentTimeMillis()))
                .withExpiresAt(new Date(System.currentTimeMillis() + (24 * 60 * 60 * 1000))) // Caduca en un día
                .sign(algorithm);

        return token;
    }
}