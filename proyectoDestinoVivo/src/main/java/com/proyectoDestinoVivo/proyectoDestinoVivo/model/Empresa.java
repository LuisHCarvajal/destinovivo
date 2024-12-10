package com.proyectoDestinoVivo.proyectoDestinoVivo.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
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

    public Empresa(int id_empresa, String nombre, String direccion, String descripcion, String horario, String telefono, String correo, String contrasena, String imagen) {
        this.id_empresa = id_empresa;
        this.nombre = nombre;
        this.direccion = direccion;
        this.descripcion = descripcion;
        this.horario = horario;
        this.telefono = telefono;
        this.correo = correo;
        this.contrasena = contrasena;
        this.imagen = imagen;
    }

    public Empresa() {
    }
    public int getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
