package com.cramirez.backendcramirez.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmpresaDTO {
    private int idEmpresa;
    private int idUbicacionINEI;
    private String nombreEmpresa;
    private String ruc;
    private String direccion;
    private String representanteLegal;
    private String nPartidaEmpresa;
}
