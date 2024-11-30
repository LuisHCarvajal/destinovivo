package com.proyectoDestinoVivo.proyectoDestinoVivo.controller;

import com.proyectoDestinoVivo.proyectoDestinoVivo.model.Tipo_Por_Empresa;
import com.proyectoDestinoVivo.proyectoDestinoVivo.service.Tipo_Por_EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Tipo_Por_EmpresaController {
    @Autowired
    Tipo_Por_EmpresaService tipo_por_empresaService;

    @PostMapping("/insertarYactualizarTipo_Por_Empresa")
    private void insertarTipo_Por_Empresa(@RequestBody Tipo_Por_Empresa tipo_por_empresa) {
        tipo_por_empresaService.insertarYactualizarTipo_Por_Empresa(tipo_por_empresa);
    }
    @GetMapping("/consultarTipo_Por_Empresa/{id}")
    public Tipo_Por_Empresa show(@PathVariable Integer id_tipo_por_empresa) {
        try{
            return tipo_por_empresaService.consultarTipo_Por_EmpresaXid(id_tipo_por_empresa);
        } catch (RuntimeException e){
            throw new RuntimeException("Error al consultar los Tipo_Por_Empresa" +e);
        }
    }
    @DeleteMapping("/eliminarTipo_Por_Empresa/{id}")
    private void eliminarTipo_Por_Empresa(@PathVariable("id") Integer id_tipo_por_empresa) {
        tipo_por_empresaService.eliminarTipo_Por_Empresa(id_tipo_por_empresa);
    }
    @PutMapping("/actualizarTipo_Por_Empresa")
    private void actualizarTipo_Por_Empresa(@PathVariable Tipo_Por_Empresa tipo_por_empresa) {
        tipo_por_empresaService.insertarYactualizarTipo_Por_Empresa(tipo_por_empresa);
    }


}
