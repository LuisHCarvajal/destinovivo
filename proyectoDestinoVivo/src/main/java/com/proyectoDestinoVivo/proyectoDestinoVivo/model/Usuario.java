package com.proyectoDestinoVivo.proyectoDestinoVivo.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Table(name = "usuario")
public class Usuario {

    @Id
    private int documento;
    @Column(nullable = false, length = 50)
    private String nombre;
    @Column(nullable = false, length = 50)
    private String correo;
    private int telefono;
    @Column(nullable = false, length = 50)
    private String nacionalidad;
    @Column(nullable = false, length = 50)
    private String fecha_nacimiento;

    }
