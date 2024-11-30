package com.proyectoDestinoVivo.proyectoDestinoVivo.service;

import com.proyectoDestinoVivo.proyectoDestinoVivo.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import com.proyectoDestinoVivo.proyectoDestinoVivo.repository.UsuarioRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario insertarUsuario(Usuario usuario){
        try {
            return usuarioRepository.save(usuario);
        } catch (DataAccessException e){
            throw new RuntimeException("Error al insertar el usuario" +e);
        }
    }

    public List<Usuario> consultarUsuario() {
        try {
            List<Usuario> usuario = new ArrayList<Usuario>();
            usuario.addAll(usuarioRepository.findAll());
            return usuario;
        } catch (DataAccessException e) {
            throw new RuntimeException("Error al consultar el usuario" +e);
        }
    }
}

