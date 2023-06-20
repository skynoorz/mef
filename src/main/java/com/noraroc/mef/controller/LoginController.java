package com.noraroc.mef.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showMyLoginPage() {

        // devolver el nombre de tu vista de login
        return "login";
    }

    // añadir solicitud de mapeo para redirigir a los usuarios
    @GetMapping("/access-denied")
    public String showAccessDenied() {

        return "access-denied";

    }

}
