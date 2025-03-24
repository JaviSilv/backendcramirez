package com.cramirez.backendcramirez.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Entity
@Table(name = "contratos")
@Getter
@Setter
public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Contrato")
    private int idContrato;

    @Column(name = "ID_Lote", nullable = false)
    private int idLote;

    @Column(name = "ID_TipoContrato", nullable = false)
    private int idTipoContrato;

    @Column(name = "ID_Cliente", nullable = false)
    private int idCliente;

    @Column(name = "ID_Documento", nullable = false)
    private int idDocumento;

    @Column(name = "Fecha_Inicio_Contrato", nullable = false)
    private Date fechaInicio;

    @Column(name = "Fecha_Fin_Contrato", nullable = false)
    private Date fechaFin;

    @Column(name = "Estado", nullable = false, length = 55)
    private String estado;

    @Column(name = "Situacion_Legal", nullable = false, length = 55)
    private String situacionLegal;

    @Column(name = "Constancia_No_Adeudo", nullable = false, length = 155)
    private String constanciaNoAdeudo;
}
