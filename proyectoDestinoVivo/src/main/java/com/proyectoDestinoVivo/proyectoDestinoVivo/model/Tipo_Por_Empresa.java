package com.proyectoDestinoVivo.proyectoDestinoVivo.model;
import jakarta.persistence.*;

@Entity
@Table(name = "tipo_por_empresa")
public class Tipo_Por_Empresa {

    @Id
    private int id_tipo_por_empresa;

    @ManyToOne
    @JoinColumn(name = "id_empresa")
    private Empresa empresa;

    @ManyToOne
    @JoinColumn(name = "id_tipo_empresa")
    private Tipo_Empresa tipo_empresa;

    public Tipo_Por_Empresa(int id_tipo_por_empresa, Empresa empresa, Tipo_Empresa tipo_empresa) {
        this.id_tipo_por_empresa = id_tipo_por_empresa;
        this.empresa = empresa;
        this.tipo_empresa = tipo_empresa;
    }

    public Tipo_Por_Empresa() {
    }

    public int getId_tipo_por_empresa() {
        return id_tipo_por_empresa;
    }

    public void setId_tipo_por_empresa(int id_tipo_por_empresa) {
        this.id_tipo_por_empresa = id_tipo_por_empresa;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Tipo_Empresa getTipo_empresa() {
        return tipo_empresa;
    }

    public void setTipo_empresa(Tipo_Empresa tipo_empresa) {
        this.tipo_empresa = tipo_empresa;
    }
}
