package com.proyectoDestinoVivo.proyectoDestinoVivo.service;

import com.proyectoDestinoVivo.proyectoDestinoVivo.model.Empresa;
import com.proyectoDestinoVivo.proyectoDestinoVivo.model.Usuario;
import com.proyectoDestinoVivo.proyectoDestinoVivo.repository.UsuarioRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;



import java.util.List;

@Service
public class UsuarioService {
    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository=usuarioRepository;
    }

    public Usuario insertarUsuario(@RequestBody  Usuario usuario) {
        try {
            return usuarioRepository.save(usuario);
        } catch (DataAccessException e) {
            throw new RuntimeException("Error al insertar el usuario" + e);
        }
    }


    public List<Usuario> consultarUsuario(){

        return usuarioRepository.findAll();
    }

    public Usuario editarUsuario(String documento, Usuario usuario){
        Usuario existente = usuarioRepository.findById(documento).orElseThrow(()->new RuntimeException("Usuario no existente"));
        existente.setNombre(usuario.getNombre());
        existente.setCorreo(usuario.getCorreo());
        existente.setTelefono(usuario.getTelefono());
        existente.setNacionalidad(usuario.getNacionalidad());
        existente.setFecha_nacimiento(usuario.getFecha_nacimiento());
        return usuarioRepository.save(existente);
    }

    public String eliminarUsuario(String documento){
        Usuario existente = usuarioRepository.findById(documento).orElseThrow(()->new RuntimeException("Usuario no existente"));
        usuarioRepository.deleteById(existente.getDocumento());
        return "Usuario eliminada correctamente";
    }
}

