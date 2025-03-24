package com.cramirez.backendcramirez.dto;

import lombok.Data;

@Data
public class FinanciamientoDTO {
    private Integer idFinanciamiento;
    private Integer idLote;
    private Float costoLote;
    private String montoLetra;
    private Float pagoInicial;
    private Float separacion;
    private Integer cantidadCuotas;
    private Float cuotasExtraordinarias;
    private Float mantenimientoMensual;
    private String mantenimientoLetras;
}
