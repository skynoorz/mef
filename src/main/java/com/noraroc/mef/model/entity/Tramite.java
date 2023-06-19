package com.noraroc.mef.model.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Getter @Setter
public class Tramite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "El codigo es obligatorio.")
    private String codigo;

    @NotEmpty(message = "El nombre es obligatorio.")
    private String nombre;

    @NotEmpty(message = "El numero de comprobante es obligatorio.")
    private String numeroComprobante;

    @NotEmpty(message = "El resumen es obligatorio.")
    private String resumen;

    @NotNull(message = "El monto es obligatorio.")
    private Double monto;

    @NotNull(message = "La fecha es obligatoria")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaConclusion;

    @NotEmpty(message = "El vinculo del documento digital es obligatorio")
    private String vinculoDocumentoDigital;

    public Tramite(Long id, String codigo, String nombre, String numeroComprobante, String resumen, Double monto, LocalDate fechaConclusion, String vinculoDocumentoDigital) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.monto = monto;
        this.fechaConclusion = fechaConclusion;
        this.vinculoDocumentoDigital = vinculoDocumentoDigital;
    }

    public Tramite() {
    }

    public Tramite(String codigo, String nombre, String numeroComprobante, String resumen, Double monto, LocalDate fechaConclusion, String vinculoDocumentoDigital) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.numeroComprobante = numeroComprobante;
        this.resumen = resumen;
        this.monto = monto;
        this.fechaConclusion = fechaConclusion;
        this.vinculoDocumentoDigital = vinculoDocumentoDigital;
    }
}
