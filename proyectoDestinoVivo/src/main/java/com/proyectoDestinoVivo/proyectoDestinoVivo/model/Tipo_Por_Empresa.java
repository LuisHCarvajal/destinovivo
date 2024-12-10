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
}
