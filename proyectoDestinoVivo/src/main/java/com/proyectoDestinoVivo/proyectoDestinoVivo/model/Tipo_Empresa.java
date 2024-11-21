package com.proyectoDestinoVivo.proyectoDestinoVivo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tipo_empresa")
public class Tipo_Empresa {

    @Id
    private int id;
    @Column(nullable = false, length = 50)
    private String nombre;

    public Tipo_Empresa(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Tipo_Empresa() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
