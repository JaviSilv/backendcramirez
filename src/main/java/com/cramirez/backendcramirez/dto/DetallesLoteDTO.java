package com.cramirez.backendcramirez.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@JsonPropertyOrder({
        "costoLote",
        "pagoInicialLote",
        "separacionLote",
        "cantidadCuotaLote",
        "cuotasExtraordinariasLote",
        "mantenimientoMensualLote"
})
public class DetallesLoteDTO {
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private int idDetallesLote;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private int idLote;

    private BigDecimal costoLote;
    private BigDecimal pagoInicialLote;
    private BigDecimal separacionLote;
    private int cantidadCuotaLote;
    private int cuotasExtraordinariasLote;
    private BigDecimal mantenimientoMensualLote;
}