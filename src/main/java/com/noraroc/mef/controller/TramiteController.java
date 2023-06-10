package com.noraroc.mef.controller;

import com.noraroc.mef.entity.Tramite;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TramiteController {

    @GetMapping("/form")
    public String formularioTramite(Model model) {
        model.addAttribute("tramite", new Tramite());
        return "formulario";
    }

    @PostMapping("/form")
    public String submitTramite(@ModelAttribute Tramite tramite) {
        System.out.println(tramite.getId());
        System.out.println(tramite.getCodigo());
        System.out.println(tramite.getNombre());
        return "resultado";
    }
}
