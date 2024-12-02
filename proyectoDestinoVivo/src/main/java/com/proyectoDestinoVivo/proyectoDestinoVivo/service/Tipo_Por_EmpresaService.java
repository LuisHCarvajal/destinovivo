package com.proyectoDestinoVivo.proyectoDestinoVivo.service;

import com.proyectoDestinoVivo.proyectoDestinoVivo.model.Tipo_Por_Empresa;
import com.proyectoDestinoVivo.proyectoDestinoVivo.repository.Tipo_Por_EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
public class Tipo_Por_EmpresaService {
    @Autowired
    Tipo_Por_EmpresaRepository tipo_por_empresaRepository;

    public Tipo_Por_EmpresaService(Tipo_Por_EmpresaRepository tipo_por_empresaRepository) {
        this.tipo_por_empresaRepository = tipo_por_empresaRepository;
    }

    public void insertarYactualizarTipo_Por_Empresa(Tipo_Por_Empresa tipo_por_empresa) {
        try {
            tipo_por_empresaRepository.save(tipo_por_empresa);
        } catch (DataAccessException e) {
            throw new RuntimeException("Error al insertar o actualizar el Tipo_Por_Empresa" + e);
        }
    }
    public Tipo_Por_Empresa consultarTipo_Por_EmpresaXid(Integer id) {
        try {
            return tipo_por_empresaRepository.findById(id).orElse(null);
        } catch (DataAccessException e) {
            throw new RuntimeException("Error al consultar el Tipo_Por_Empresa" + e);
        }
    }

    public void eliminarTipo_Por_Empresa(Integer id) {
        tipo_por_empresaRepository.deleteById(id);

    }
}
