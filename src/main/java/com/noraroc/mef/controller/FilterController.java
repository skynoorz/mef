package com.noraroc.mef.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FilterController {

    @GetMapping("/filter")
    public String filterView(Model model) {
        return "filter";
    }
}
