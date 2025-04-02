package com.cramirez.backendcramirez.dto.lote;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonPropertyOrder({
        "nombreProyecto",
        "manzana",
        "numeroLote",
        "tipoContrato",
        "areaLote",
        "ubicacion",
        "unidadCatastral",
        "partidaLoteMatriz"
})
public class LoteDTO {
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private int idLote;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private int idProyecto;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private int idContrato;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private int idClienteLote;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private int idOperario;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private int idUbicacion;


    private String NombreProyecto;
    private String TipoContrato;

    private int numeroLote;
    private String manzana;
    private String areaLote;
    private String Ubicacion;
    private String unidadCatastral;
    private String partidaLoteMatriz;
}
