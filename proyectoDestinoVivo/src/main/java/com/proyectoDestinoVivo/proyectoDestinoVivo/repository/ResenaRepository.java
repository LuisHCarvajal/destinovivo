package com.proyectoDestinoVivo.proyectoDestinoVivo.repository;
import com.proyectoDestinoVivo.proyectoDestinoVivo.model.Resena;
import com.proyectoDestinoVivo.proyectoDestinoVivo.model.Usuario;
import com.proyectoDestinoVivo.proyectoDestinoVivo.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ResenaRepository extends JpaRepository <Resena, Integer> {

}
