package com.proyectoDestinoVivo.proyectoDestinoVivo.repository;

import com.proyectoDestinoVivo.proyectoDestinoVivo.model.Servicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicioRepository extends JpaRepository <Servicio, Integer> {
}

