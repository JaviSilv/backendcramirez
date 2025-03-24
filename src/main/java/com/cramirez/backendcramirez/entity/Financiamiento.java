package com.cramirez.backendcramirez.entity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Financiamiento")
@Data
public class Financiamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Financiamiento")
    private int idFinanciamiento;

    @Column(name = "ID_Lote", nullable = false)
    private Integer idLote;

    @Column(name = "Costo_Lote", nullable = false)
    private Float costoLote;

    @Column(name = "Monto_Letra", nullable = false, length = 255)
    private String montoLetra;

    @Column(name = "Pago_Inicial", nullable = false )
    private Float pagoInicial;

    @Column(name = "Separacion", nullable = false)
    private Float separacion;

    @Column(name = "Cantidad_Cuotas", nullable = false)
    private Integer cantidadCuotas;

    @Column(name = "Cuotas_Extraordinarias", nullable = false)
    private Float cuotasExtraordinarias;

    @Column(name = "Mantenimiento_Mensual", nullable = false)
    private Float mantenimientoMensual;

    @Column(name = "Mantenimiento_Letras", nullable = false, length = 255)
    private String mantenimientoLetras;


}

