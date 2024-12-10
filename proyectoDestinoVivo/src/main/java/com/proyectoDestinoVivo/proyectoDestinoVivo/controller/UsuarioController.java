package com.proyectoDestinoVivo.proyectoDestinoVivo.controller;

import com.proyectoDestinoVivo.proyectoDestinoVivo.model.Usuario;
import com.proyectoDestinoVivo.proyectoDestinoVivo.service.UsuarioService;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;


import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }
    @PostMapping("usuarios/insertar")
    public Usuario insertar(@RequestBody Usuario usuario){
        try {
            return usuarioService.insertarUsuario(usuario);
        }catch (RuntimeException e){
            throw new RuntimeException("Error al insertar el usuario" +e);
        }

    }
    @GetMapping("usuarios/consultar")
    public List<Usuario> consultar(){
        try{
            return usuarioService.consultarUsuario();
        }catch (RuntimeException e){
            throw new RuntimeException("Error al consultar los usuarios" +e);
        }
    }

    @PutMapping("/usuarios/editar/{documento}")
    public ResponseEntity<Usuario> editarUsuario(@PathVariable String documento, @RequestBody Usuario usuario){
        Usuario actualizado = usuarioService.editarUsuario(documento, usuario);
        return ResponseEntity.ok(actualizado);

    }

    @DeleteMapping("/usuarios/eliminar/{documento}")
    public String eliminarUsuario(@PathVariable String documento, @RequestBody Usuario usuario){
        return usuarioService.eliminarUsuario(documento);
    }

}
