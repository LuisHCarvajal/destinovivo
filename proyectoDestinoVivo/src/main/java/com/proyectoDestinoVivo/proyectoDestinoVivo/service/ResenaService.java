package com.proyectoDestinoVivo.proyectoDestinoVivo.service;

import com.proyectoDestinoVivo.proyectoDestinoVivo.model.Empresa;
import com.proyectoDestinoVivo.proyectoDestinoVivo.model.Red_Social;
import com.proyectoDestinoVivo.proyectoDestinoVivo.model.Resena;
import com.proyectoDestinoVivo.proyectoDestinoVivo.model.Usuario;
import com.proyectoDestinoVivo.proyectoDestinoVivo.repository.EmpresaRepository;
import com.proyectoDestinoVivo.proyectoDestinoVivo.repository.ResenaRepository;
import com.proyectoDestinoVivo.proyectoDestinoVivo.repository.UsuarioRepository;
import org.springframework.stereotype.Service;


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

        Usuario usuario = usuarioRepository.findById(resena.getUsuario().getDocumento())
                .orElseThrow(()->new IllegalArgumentException("Usuario no encontrado"));

        // Buscar y asignar empresa
        Empresa empresa = empresaRepository.findById(resena.getEmpresa().getId_empresa())
                .orElseThrow(()->new IllegalArgumentException("Empresa no encontrado"));


        return resenaRepository.save(resena);

    }

    public List<Resena> consultarResena(){
        return  resenaRepository.findAll();
    }

    public Resena editarResena(int id_resena, Resena resena){
        Resena existente = resenaRepository.findById(id_resena).orElseThrow(()->new RuntimeException("Reseña no existente"));
        existente.setEmpresa(resena.getEmpresa());
        existente.setUsuario(resena.getUsuario());
        existente.setResena(resena.getResena());
        existente.setCalificacion(resena.getCalificacion());
        return resenaRepository.save(existente);
    }

    public String eliminarResena(int id_resena){
        Resena existente = resenaRepository.findById(id_resena).orElseThrow(()->new RuntimeException("Reseña no existente"));
        resenaRepository.deleteById(existente.getId_resena());
        return "Reseña eliminada correctamente";
    }
}
