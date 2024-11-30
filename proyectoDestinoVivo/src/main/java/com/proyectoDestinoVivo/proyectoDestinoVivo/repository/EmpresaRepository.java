package com.proyectoDestinoVivo.proyectoDestinoVivo.repository;
import com.proyectoDestinoVivo.proyectoDestinoVivo.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface  EmpresaRepository extends JpaRepository <Empresa, Integer> {
}
