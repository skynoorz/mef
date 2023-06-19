package com.noraroc.mef.controller.rest;

import com.noraroc.mef.model.dao.TramiteRepository;
import com.noraroc.mef.model.entity.Tramite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FilterRestController {

    @Autowired
    private TramiteRepository tramiteRepository;

    @GetMapping("/tramite/find")
    public List<Tramite> filterProducts(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) String codigo,
            @RequestParam(required = false) String nombre,
            @RequestParam(required = false) String numeroComprobante,
            @RequestParam(required = false) String resumen,
            @RequestParam(required = false) Double monto

    ) {
        List<Tramite> tramites = tramiteRepository.buscarPorParametros(id, codigo, nombre, numeroComprobante, resumen, monto);
        return tramites;
    }
}
