package com.proyectoDestinoVivo.proyectoDestinoVivo.controller;

import com.proyectoDestinoVivo.proyectoDestinoVivo.model.Usuario;
import com.proyectoDestinoVivo.proyectoDestinoVivo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsuarioController {
    @Autowired
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    @PostMapping("/insertarUsuario")
    public Usuario insertar(@RequestBody Usuario usuario){
        try {
            return usuarioService.insertarUsuario(usuario);
        }catch (RuntimeException e){
            throw new RuntimeException("Error al insertar el usuario" +e);
        }

    }
    @GetMapping("/consultarUsuario")
    public List<Usuario> consultar(){
        try{
            return usuarioService.consultarUsuario();
        }catch (RuntimeException e){
            throw new RuntimeException("Erro al consultar los usuarios" +e);
        }
    }
}
