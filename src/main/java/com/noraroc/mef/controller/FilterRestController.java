package com.noraroc.mef.controller;

import com.noraroc.mef.dao.TramiteRepository;
import com.noraroc.mef.entity.Tramite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class FilterRestController {

    @Autowired
    private TramiteRepository tramiteRepository;

    @GetMapping("/filter/tramite")
    public List<Tramite> filterProducts(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) String codigo,
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) String numeroComprobante,
            @RequestParam(required = false) String resumen,
            @RequestParam(required = false) Double monto,
            @RequestParam(required = false) LocalDate fechaConclusion,
            @RequestParam(required = false) String vinculo
    ) {
        List<Tramite> tramites = tramiteRepository.buscarPorParametros(id, codigo, nombre, numeroComprobante, resumen, monto, fechaConclusion, vinculo);
        return tramites;
    }
}
