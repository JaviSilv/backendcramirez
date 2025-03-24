package com.cramirez.backendcramirez.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DocumentoDTO {
    private int idDocumento;
    private String cartaNoAdeudo;
    private String certificadoLote;
    private String mediosPago;
    private String minutaEscaneada;
}
