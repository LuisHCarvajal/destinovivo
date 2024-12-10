package com.proyectoDestinoVivo.proyectoDestinoVivo.controller;

import com.proyectoDestinoVivo.proyectoDestinoVivo.model.Servicio;
import com.proyectoDestinoVivo.proyectoDestinoVivo.model.Tipo_Empresa;
import com.proyectoDestinoVivo.proyectoDestinoVivo.service.ServicioService;
import com.proyectoDestinoVivo.proyectoDestinoVivo.service.Tipo_EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Tipo_EmpresaController {
    @Autowired
    Tipo_EmpresaService tipo_empresaService;

    @PostMapping("/insertarYactualizarTipo_Empresa")
    private void insertarTipo_Empresa(@RequestBody Tipo_Empresa tipo_empresa) {
        tipo_empresaService.insertarYactualizarTipo_Empresa(tipo_empresa);
    }
    @GetMapping("/consultarTipo_Empresa/{id}")
    public Tipo_Empresa show(@PathVariable Integer id) {
        try{
            return tipo_empresaService.consultarTipo_EmpresaXid(id);
        } catch (RuntimeException e){
            throw new RuntimeException("Error al consultar los Tipo_Empresas" +e);
        }
    }
    @DeleteMapping("/eliminarTipo_Empresa/{id}")
    private void eliminarTipo_Empresa(@PathVariable("id") Integer id) {
        tipo_empresaService.eliminarTipo_Empresa(id);
    }
    @PutMapping("/actualizarTipo_Empresa")
    private void actualizarTipo_Empresa(@PathVariable Tipo_Empresa Tipo_Empresa) {
        tipo_empresaService.insertarYactualizarTipo_Empresa(Tipo_Empresa);
    }


}