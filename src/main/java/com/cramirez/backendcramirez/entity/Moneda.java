package com.cramirez.backendcramirez.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Moneda")
@Data
public class Moneda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_Moneda")
    private Integer idMoneda;

    @Column(name="Monedas",nullable = false)
    private String monedas;
}

