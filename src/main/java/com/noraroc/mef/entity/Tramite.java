package com.noraroc.mef.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter @Setter
public class Tramite {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String codigo;
    private String nombre;
    private String numeroComprobante;
    private String resumen;
    private Double monto;
    private LocalDate fechaConclusion;
    private String vinculoDocumentoDigital;
}
