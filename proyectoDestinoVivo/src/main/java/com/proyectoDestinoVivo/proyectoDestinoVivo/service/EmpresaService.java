package com.proyectoDestinoVivo.proyectoDestinoVivo.service;

import com.proyectoDestinoVivo.proyectoDestinoVivo.model.Empresa;
import com.proyectoDestinoVivo.proyectoDestinoVivo.repository.EmpresaRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaService {
    private EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public Empresa insertarEmpresa(Empresa empresa){
        try {
            return empresaRepository.save(empresa);
        }catch (DataAccessException e){
            throw new RuntimeException("Error al insertar la empresa" +e);
        }
    }

    public List<Empresa> consultarEmpresas(){
        return empresaRepository.findAll();
    }
}
