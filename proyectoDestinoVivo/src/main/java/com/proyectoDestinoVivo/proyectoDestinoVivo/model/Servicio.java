package com.proyectoDestinoVivo.proyectoDestinoVivo.model;
import jakarta.persistence.*;

@Entity
@Table(name = "servicio")
public class Servicio {

    @Id
    private int id_servicio;

    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;

    @Column(nullable = false, length = 50)
    private String nombre;
    private Long precio;
    @Column(nullable = false, length = 250)
    private String descripcion;

    public Servicio(int id_servicio, Empresa empresa, String nombre, Long precio, String descripcion) {
        this.id_servicio = id_servicio;
        this.empresa = empresa;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    public Servicio() {
    }

    public int getId_servicio() {
        return id_servicio;
    }

    public void setId_servicio(int id_servicio) {
        this.id_servicio = id_servicio;
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

    public Long getPrecio() {
        return precio;
    }

    public void setPrecio(Long precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
