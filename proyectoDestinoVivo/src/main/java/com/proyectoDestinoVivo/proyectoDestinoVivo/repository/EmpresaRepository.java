package com.proyectoDestinoVivo.proyectoDestinoVivo.repository;


import com.proyectoDestinoVivo.proyectoDestinoVivo.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository <Empresa, Integer> {
}
