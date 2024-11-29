package com.proyectoDestinoVivo.proyectoDestinoVivo.controller;

import com.proyectoDestinoVivo.proyectoDestinoVivo.model.Red_Social;
import com.proyectoDestinoVivo.proyectoDestinoVivo.service.Red_SocialService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Red_SocialController {
    private final Red_SocialService red_SocialService;

    public Red_SocialController(Red_SocialService red_SocialService) {
        this.red_SocialService = red_SocialService;
    }
    @PostMapping("/red_social/insertar")
    public Red_Social insertar(@RequestBody Red_Social red_social){
        try {
            return red_SocialService.insertarRed_Social(red_social);
        }catch (RuntimeException e){
            throw new RuntimeException("Error al insertar la red social" +e);
        }
    }
    @GetMapping("/red_social/consultar")
    public List<Red_Social>consultar(){
        try{
            return red_SocialService.consultarRed_Social();
        }catch (RuntimeException e){
            throw new RuntimeException("Error al consultar las redes sociales" +e);
        }
    }
    @PutMapping("/red_social/editar/{id_redes}")
    public ResponseEntity<Red_Social>editarRed_Social(@PathVariable int id_redes,@RequestBody Red_Social red_social){
        Red_Social actualizada = red_SocialService.editarRed_Social(id_redes ,red_social);
        return ResponseEntity.ok(actualizada);
    }

    @DeleteMapping("/red_social/eliminar/{id_redes}")
    public String deliminarRed_Social(@PathVariable int id_redes,@RequestBody Red_Social red_social){
        return red_SocialService.eliminarRed_Social(id_redes);
    }

}
