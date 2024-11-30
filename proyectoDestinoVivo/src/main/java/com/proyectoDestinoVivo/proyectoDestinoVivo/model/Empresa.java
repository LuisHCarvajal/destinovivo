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
@Data   //remplaza los getter and setter
@ToString
@Table(name = "empresa")
public class Empresa {

    @Id
    private int id_empresa;
    @Column(nullable = false, length = 50)
    private String nombre;
    @Column(nullable = false, length = 50)
    private String direccion;
    @Column(nullable = false, length = 250)
    private String descripcion;
    @Column(nullable = false, length = 100)
    private String horario;
    @Column(nullable = false, length = 20)
    private String telefono;
    @Column(nullable = false, length = 50)
    private String correo;
    @Column(nullable = false, length = 20)
    private String contrasena;
    @Column(nullable = false, length = 200)
    private String imagen;

}