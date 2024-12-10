package com.proyectoDestinoVivo.proyectoDestinoVivo.controller;

import com.proyectoDestinoVivo.proyectoDestinoVivo.model.Servicio;
import com.proyectoDestinoVivo.proyectoDestinoVivo.model.Usuario;
import com.proyectoDestinoVivo.proyectoDestinoVivo.repository.ServicioRepository;
import com.proyectoDestinoVivo.proyectoDestinoVivo.service.ServicioService;
import com.proyectoDestinoVivo.proyectoDestinoVivo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ServicioController {
    @Autowired
    ServicioService servicioService;

    @PostMapping("/insertarYactualizarservicio")
    private void insertarServicio(@RequestBody Servicio servicio) {
        servicioService.insertarYactualizarServicio(servicio);
    }
    @GetMapping("/consultarServicio/{id}")
    public Servicio show(@PathVariable Integer id) {
        try{
            return servicioService.consultarServicioXid(id);
        } catch (RuntimeException e){
            throw new RuntimeException("Error al consultar los servicios" +e);
        }
    }
    @DeleteMapping("/eliminarServicio/{id}")
    private void eliminarServicio(@PathVariable("id") Integer id) {
        servicioService.eliminarServicio(id);
    }
    @PutMapping("/actualizarServicio")
    private void actualizarServicio(@PathVariable Servicio servicio) {
        servicioService.insertarYactualizarServicio(servicio);
    }


}
