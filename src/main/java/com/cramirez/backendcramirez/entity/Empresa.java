package com.cramirez.backendcramirez.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Empresa")
@Getter
@Setter
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Empresa")
    private int idEmpresa;

    @Column(name = "ID_UbicacionINEI", nullable = false)
    private int idUbicacionINEI;

    @Column(name = "Nombre_Empresa", nullable = false, length = 70)
    private String nombreEmpresa;

    @Column(name = "RUC", nullable = false, length = 55)
    private String ruc;

    @Column(name = "Direccion", nullable = false, length = 55)
    private String direccion;

    @Column(name = "Representante_Legal", nullable = false, length = 55)
    private String representanteLegal;

    @Column(name = "N_PartidaEmpresa", nullable = false, length = 25)
    private String nPartidaEmpresa;
}
