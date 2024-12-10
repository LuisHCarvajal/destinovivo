package com.proyectoDestinoVivo.proyectoDestinoVivo.controller;

import com.proyectoDestinoVivo.proyectoDestinoVivo.model.Red_Social;
import com.proyectoDestinoVivo.proyectoDestinoVivo.model.Resena;
import com.proyectoDestinoVivo.proyectoDestinoVivo.service.ResenaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @PutMapping("/resenas/editar/{id_resena}")
    public ResponseEntity<Resena> editarResena(@PathVariable int id_resena, @RequestBody Resena resena){
        Resena actualizada = resenaService.editarResena(id_resena ,resena);
        return ResponseEntity.ok(actualizada);
    }

    @DeleteMapping("/resenas/eliminar/{id_resena}")
    public String eliminarResena(@PathVariable int id_resena,@RequestBody Resena resena){
        return resenaService.eliminarResena(id_resena);
    }
}
