package com.cramirez.backendcramirez.dto;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
public class ContratoDTO {
    private int idContrato;
    private int idLote;
    private int idTipoContrato;
    private int idCliente;
    private int idDocumento;
    private Date fechaInicio;
    private Date fechaFin;
    private String estado;
    private String situacionLegal;
    private String constanciaNoAdeudo;
}
