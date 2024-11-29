package com.proyectoDestinoVivo.proyectoDestinoVivo.controller;

import com.proyectoDestinoVivo.proyectoDestinoVivo.model.Resena;
import com.proyectoDestinoVivo.proyectoDestinoVivo.service.ResenaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resenas/insertar")
public class ResenaController {

    private final ResenaService resenaService;

    public ResenaController(ResenaService resenaService) {
        this.resenaService = resenaService;
    }

    @PostMapping
    public ResponseEntity<Resena>insertarResena(@RequestBody Resena resena){
        Resena nuevaResena = resenaService.insertarResena(resena);
        return new ResponseEntity<>(nuevaResena, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Resena>> listarResenas(){
        List<Resena> resenas = resenaService.consultarResena();
        return new ResponseEntity<>(resenas, HttpStatus.OK);
    }

}

