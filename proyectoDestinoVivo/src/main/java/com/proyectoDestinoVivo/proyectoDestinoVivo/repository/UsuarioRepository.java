package com.proyectoDestinoVivo.proyectoDestinoVivo.repository;
import com.proyectoDestinoVivo.proyectoDestinoVivo.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UsuarioRepository extends JpaRepository <Usuario, String> {
}
