package com.proyectoDestinoVivo.proyectoDestinoVivo.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Table(name = "servicio")
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_servicio", nullable = false)
    private int id_servicio;

    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;

    @Column(nullable = false, length = 50)
    private String nombre;
    private Long precio;
    @Column(nullable = false, length = 250)
    private String descripcion;
}