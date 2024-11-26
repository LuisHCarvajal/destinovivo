package com.proyectoDestinoVivo.proyectoDestinoVivo.controller;

import com.proyectoDestinoVivo.proyectoDestinoVivo.model.Empresa;
import com.proyectoDestinoVivo.proyectoDestinoVivo.service.EmpresaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmpresaController {
    private final EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }
    @PostMapping("/empresas/insertar")
    public Empresa insertar(@RequestBody Empresa empresa){
        try {
            return empresaService.insertarEmpresa(empresa);
        }catch (RuntimeException e){
            throw new RuntimeException("Error al insertar la empresa" +e);
        }

    }
    @GetMapping("/empresas/consultar")
    public List<Empresa> consultar(){
        try{
            return empresaService.consultarEmpresas();
        }catch (RuntimeException e){
            throw new RuntimeException("Erro al consultar las empresas" +e);
        }
    }
}
