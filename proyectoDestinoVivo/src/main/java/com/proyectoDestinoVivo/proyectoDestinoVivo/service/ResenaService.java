package com.proyectoDestinoVivo.proyectoDestinoVivo.service;

import com.proyectoDestinoVivo.proyectoDestinoVivo.model.Empresa;
import com.proyectoDestinoVivo.proyectoDestinoVivo.model.Resena;
import com.proyectoDestinoVivo.proyectoDestinoVivo.model.Usuario;
import com.proyectoDestinoVivo.proyectoDestinoVivo.repository.EmpresaRepository;
import com.proyectoDestinoVivo.proyectoDestinoVivo.repository.ResenaRepository;
import com.proyectoDestinoVivo.proyectoDestinoVivo.repository.UsuarioRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.List;

@Service
public class ResenaService {
    private ResenaRepository resenaRepository;
    private final UsuarioRepository usuarioRepository;
    private final EmpresaRepository empresaRepository;

    public ResenaService(UsuarioRepository usuarioRepository, ResenaRepository resenaRepository, EmpresaRepository empresaRepository) {
        this.usuarioRepository = usuarioRepository;
        this.resenaRepository = resenaRepository;
        this.empresaRepository = empresaRepository;
    }

    public Resena insertarResena(Resena resena){
        System.out.println(resena);
        Usuario usuario = usuarioRepository.findById(resena.getUsuario().getDocumento())
                .orElseThrow(()->new IllegalArgumentException("Usuario no encontrado"));

        Empresa empresa = empresaRepository.findById(resena.getEmpresa().getId_empresa())
                .orElseThrow(()->new IllegalArgumentException("Empresa no encontrado"));


        return resenaRepository.save(resena);

    }

    public List<Resena> consultarResena(){
        return  resenaRepository.findAll();
    }
}
