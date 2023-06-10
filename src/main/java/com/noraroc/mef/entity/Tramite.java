package com.noraroc.mef.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
