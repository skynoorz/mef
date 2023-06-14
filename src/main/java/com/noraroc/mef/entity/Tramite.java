package com.noraroc.mef.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

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

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaConclusion;
    private String vinculoDocumentoDigital;

    public Tramite(Long id, String codigo, String nombre, String numeroComprobante, String resumen, Double monto, LocalDate fechaConclusion, String vinculoDocumentoDigital) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.numeroComprobante = numeroComprobante;
        this.resumen = resumen;
        this.monto = monto;
        this.fechaConclusion = fechaConclusion;
        this.vinculoDocumentoDigital = vinculoDocumentoDigital;
    }

    public Tramite() {
    }
}
