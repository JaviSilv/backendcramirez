package com.cramirez.backendcramirez.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Proyecto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Proyecto")
    private int idProyecto;

    @Column(name = "ID_Empresa", nullable = false)
    private int idEmpresa;

    @Column(name = "Nombre_Proyecto")
    private String nombreProyecto;
}
