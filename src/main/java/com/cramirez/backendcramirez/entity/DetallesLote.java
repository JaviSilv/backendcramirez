    package com.cramirez.backendcramirez.entity;

    import jakarta.persistence.*;
    import lombok.Getter;
    import lombok.Setter;

    import java.math.BigDecimal;

    @Getter
    @Setter
    @Entity
    @Table(name = "DetallesLote")
    public class DetallesLote {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "ID_DetallesLote")
        private int idDetallesLote;

        @Column(name = "ID_Lote", nullable = false)
        private int idLote;

        @Column(name = "CostoLote", nullable = false)
        private BigDecimal costoLote;

        @Column(name = "PagoInicial", nullable = false)
        private BigDecimal pagoInicialLote;

        @Column(name = "Separacion", nullable = false)
        private BigDecimal separacionLote;

        @Column(name = "CantidadCuota", nullable = false)
        private int cantidadCuotaLote;

        @Column(name = "CuotasExtraordinarias", nullable = false)
        private int cuotasExtraordinariasLote;

        @Column(name = "MantenimientoMensual", nullable = false)
        private BigDecimal mantenimientoMensualLote;
    }