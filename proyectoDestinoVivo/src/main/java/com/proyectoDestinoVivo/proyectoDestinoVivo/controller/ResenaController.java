package com.proyectoDestinoVivo.proyectoDestinoVivo.controller;

import com.proyectoDestinoVivo.proyectoDestinoVivo.model.Resena;
import com.proyectoDestinoVivo.proyectoDestinoVivo.service.ResenaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ResenaController {

    private final ResenaService resenaService;

    public ResenaController(ResenaService resenaService) {this.resenaService = resenaService;}

    @PostMapping("/resenas/insertar")
    public Resena insertarresena(@RequestBody Resena resena){
        try{
            return resenaService.insertarResena(resena);
        }catch (RuntimeException e){
            throw new RuntimeException("Error al insertar la reseña" +e);
        }
    }
    @GetMapping("/resenas/consultar")
    public List<Resena> consultarresena(){
        try{
            return resenaService.consultarResena();
        }catch (RuntimeException e){
           throw  new RuntimeException("Error al consultar las reseñas" +e);
        }
    }
}
