package com.noraroc.mef.controller;

import com.noraroc.mef.dao.TramiteRepository;
import com.noraroc.mef.entity.Tramite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
public class FilterController {

    @Autowired
    private TramiteRepository tramiteRepository;

    @GetMapping("/filter")
    public String filterView(Model model) {
        List<Tramite> tramites = tramiteRepository.findAll();
        model.addAttribute("tramites", tramites);
        return "filter";
    }
//    @GetMapping("/filter/tramite")
//    public List<Tramite> filterProducts(
//            @RequestParam(required = false) Long id,
//            @RequestParam(required = false) String codigo,
//            @RequestParam(required = false) String nombre,
//            @RequestParam(required = false) String numero_comprobante,
//            @RequestParam(required = false) String resumen,
//            @RequestParam(required = false) Double monto,
//            @RequestParam(required = false) LocalDate fecha_conclusion,
//            @RequestParam(required = false) String vinculo
//    ) {
//        List<Tramite> tramites = tramiteRepository.findByIdAndCodigoAndNombreAndNumeroComprobanteAndResumenAndMontoAndFechaConclusionAndVinculoDocumentoDigital(id, codigo,nombre,numero_comprobante,resumen,monto,fecha_conclusion,vinculo);
//        return tramites;
//    }




}
