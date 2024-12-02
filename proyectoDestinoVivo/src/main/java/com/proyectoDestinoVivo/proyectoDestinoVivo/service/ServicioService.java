package com.proyectoDestinoVivo.proyectoDestinoVivo.service;

import com.proyectoDestinoVivo.proyectoDestinoVivo.model.Servicio;
import com.proyectoDestinoVivo.proyectoDestinoVivo.model.Usuario;
import com.proyectoDestinoVivo.proyectoDestinoVivo.repository.ServicioRepository;
import jakarta.persistence.Id;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class ServicioService {
    @Autowired
    ServicioRepository servicioRepository;

    public ServicioService(ServicioRepository servicioRepository) {
        this.servicioRepository = servicioRepository;
    }

    public void insertarYactualizarServicio(Servicio servicio) {
        try {
            servicioRepository.save(servicio);
        } catch (DataAccessException e) {
            throw new RuntimeException("Error al insertar o actualizar el servicio" + e);
        }
    }
public Servicio consultarServicioXid(Integer id) {
    try {
       return servicioRepository.findById(id).orElse(null);
    } catch (DataAccessException e) {
            throw new RuntimeException("Error al consultar el servicio" + e);
        }
}

    public void eliminarServicio(Integer id_servicio) {
        servicioRepository.deleteById(id_servicio);

    }
}