package com.cramirez.backendcramirez.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Documentos")
@Getter
@Setter
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Documento")
    private int idDocumento;

    @Column(name = "Carta_No_Adeudo", nullable = false, length = 255)
    private String cartaNoAdeudo;

    @Column(name = "Certificado_Lote", nullable = false, length = 255)
    private String certificadoLote;

    @Column(name = "Medios_Pago", nullable = false, length = 30)
    private String mediosPago;

    @Column(name = "Minuta_Escaneada", nullable = false, length = 255)
    private String minutaEscaneada;
}
