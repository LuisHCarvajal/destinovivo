package com.proyectoDestinoVivo.proyectoDestinoVivo.repository;

import com.proyectoDestinoVivo.proyectoDestinoVivo.model.Tipo_Por_Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Tipo_Por_EmpresaRepository extends JpaRepository <Tipo_Por_Empresa, Integer> {
}
