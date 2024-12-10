package com.proyectoDestinoVivo.proyectoDestinoVivo.model;
import jakarta.persistence.*;

@Entity
@Table(name = "red_social")
public class Red_Social {

    @Id
    private int id_redes;

    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;

    @Column(nullable = false, length = 50)
    private String nombre;
    @Column(nullable = false, length = 100)
    private String enlace;

    public Red_Social(int id_redes, Empresa empresa, String nombre, String enlace) {
        this.id_redes = id_redes;
        this.empresa = empresa;
        this.nombre = nombre;
        this.enlace = enlace;
    }

    public Red_Social() {
    }

    public int getId_redes() {
        return id_redes;
    }

    public void setId_redes(int id_redes) {
        this.id_redes = id_redes;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEnlace() {
        return enlace;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }

    public int getId_red_social() { return id_redes;
    }
}
