package com.proyectoDestinoVivo.proyectoDestinoVivo.service;

import com.proyectoDestinoVivo.proyectoDestinoVivo.model.Tipo_Empresa;
import com.proyectoDestinoVivo.proyectoDestinoVivo.repository.Tipo_EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class Tipo_EmpresaService {
        @Autowired
        Tipo_EmpresaRepository tipo_empresaRepository;

        public Tipo_EmpresaService(Tipo_EmpresaRepository tipo_empresaRepository) {
            this.tipo_empresaRepository = tipo_empresaRepository;
        }

        public void insertarYactualizarTipo_Empresa(Tipo_Empresa tipo_empresa) {
            try {
                tipo_empresaRepository.save(tipo_empresa);
            } catch (DataAccessException e) {
                throw new RuntimeException("Error al insertar o actualizar el Tipo_Empresa" + e);
            }
        }
        public Tipo_Empresa consultarTipo_EmpresaXid(Integer id) {
            try {
                return tipo_empresaRepository.findById(id).orElse(null);
            } catch (DataAccessException e) {
                throw new RuntimeException("Error al consultar el Tipo_Empresa" + e);
            }
        }

        public void eliminarTipo_Empresa(Integer id) {
            tipo_empresaRepository.deleteById(id);

        }
    }
