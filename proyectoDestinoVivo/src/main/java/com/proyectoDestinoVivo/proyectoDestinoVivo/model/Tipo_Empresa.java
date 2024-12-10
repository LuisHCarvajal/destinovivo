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
@Table(name = "tipo_empresa")
public class Tipo_Empresa {
    @Id
    private int id;
    @Column(nullable = false, length = 50)
    private String nombre;

}
