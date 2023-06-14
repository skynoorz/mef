package com.noraroc.mef.controller;

import com.noraroc.mef.dao.TramiteRepository;
import com.noraroc.mef.entity.Tramite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
