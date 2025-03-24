package com.cramirez.backendcramirez.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Lote")
@Data
public class Lote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Lote",nullable = false)
    private int idLote;

    @Column(name="ID_Proyecto",nullable = false)
    private int idProyecto;

    @Column(name="ID_Contrato",nullable = false)
    private int idContrato;

    @Column(name="ID_Cliente",nullable = false)
    private int idClienteLote;

    @Column(name="NumeroLote",nullable = false)
    private int numeroLote;

    @Column(name = "ID_Operario",nullable = false)
    private int idOperario;

    @Column(name="Manzana",nullable = false)
    private String manzana;

    @Column(name="Area_Lote",nullable = false)
    private String areaLote;

    @Column(name="Ubicacion",nullable = false)
    private String ubicacion;

    @Column(name="Unidad_Catastral",nullable = false)
    private String unidadCatastral;

    @Column(name="Partida_Lote_Matriz",nullable = false)
    private String partidaLoteMatriz;

    @Column(name="Urbanizacion",nullable = false)
    private String urbanizacion;
}
