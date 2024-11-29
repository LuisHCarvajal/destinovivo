package com.proyectoDestinoVivo.proyectoDestinoVivo.service;

import com.proyectoDestinoVivo.proyectoDestinoVivo.model.Empresa;
import com.proyectoDestinoVivo.proyectoDestinoVivo.model.Red_Social;
import com.proyectoDestinoVivo.proyectoDestinoVivo.repository.EmpresaRepository;
import com.proyectoDestinoVivo.proyectoDestinoVivo.repository.Red_SocialRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Service
public class Red_SocialService {
    private Red_SocialRepository red_socialRepository;
    private EmpresaRepository empresaRepository;

    public Red_SocialService(EmpresaRepository empresaRepository, Red_SocialRepository red_socialRepository) {
        this.empresaRepository = empresaRepository;
        this.red_socialRepository = red_socialRepository;
    }

    public Red_Social insertarRed_Social(@RequestBody Red_Social red_social){
        try {
            Empresa empresa = empresaRepository.findById(red_social.getEmpresa().getId_empresa()).orElseThrow(()->new RuntimeException("Empresa no existente"));
            return red_socialRepository.save(red_social);
        }catch (DataAccessException e){
            throw new RuntimeException("Error al insertar la Red Social" +e);
        }
    }

    public List<Red_Social> consultarRed_Social(){
        return red_socialRepository.findAll();
    }

    public Red_Social editarRed_Social(int id_redes, Red_Social red_social){
        Red_Social existente = red_socialRepository.findById(id_redes).orElseThrow(()->new RuntimeException("Red Social no existente"));
        existente.setEmpresa(red_social.getEmpresa());
        existente.setNombre(red_social.getNombre());
        existente.setEnlace(red_social.getEnlace());
        return red_socialRepository.save(existente);
    }

    public String eliminarRed_Social(int id_redes){
        Red_Social existente = red_socialRepository.findById(id_redes).orElseThrow(()->new RuntimeException("Red Social no existente"));
        red_socialRepository.deleteById(existente.getId_red_social());
        return "Red Social eliminada correctamente";
    }


}
