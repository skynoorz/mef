package com.noraroc.mef.controller;

import com.noraroc.mef.model.entity.Tramite;
import com.noraroc.mef.model.service.TramiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/tramite/filter")
public class FilterController {

    @Autowired
    private TramiteService tramiteService;

    @GetMapping
    public String filterView(Model model) {
        List<Tramite> tramites = tramiteService.findAll();
        model.addAttribute("tramites", tramites);
        return "tramites";
    }

    @GetMapping("/form")
    public String formView(@ModelAttribute Tramite tramite, Model model){
        model.addAttribute(tramite);
        return "form_filter";
    }

    @PostMapping
    public String procesarFormulario(@ModelAttribute Tramite tramite, Model model) {
        List<Tramite> tramites = tramiteService.search(tramite);
        model.addAttribute("tramites", tramites);
        return "tramites";
    }
}
