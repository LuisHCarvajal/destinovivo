package com.proyectoDestinoVivo.proyectoDestinoVivo.model;
import jakarta.persistence.*;

@Entity
@Table(name = "resena")
public class Resena {

    @Id
    private int id_resena;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;

    @Column(nullable = false, length = 50)
    private String resena;
    private int calificacion;

    public Resena(int id_resena, Usuario usuario, Empresa empresa, String resena, int calificacion) {
        this.id_resena = id_resena;
        this.usuario = usuario;
        this.empresa = empresa;
        this.resena = resena;
        this.calificacion = calificacion;
    }

    public Resena(){

    }

    public int getId_resena() {
        return id_resena;
    }

    public void setId_resena(int id_resena) {
        this.id_resena = id_resena;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getResena() {
        return resena;
    }

    public void setResena(String resena) {
        this.resena = resena;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }
}
