package com.noraroc.mef.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Authentication authentication) {
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        // Redireccionar al administrador a '/filter'
        if (authorities.stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
            return "redirect:/tramite/filter";
        }

        // Redireccionar al usuario a '/form'
        else if (authorities.stream().anyMatch(a -> a.getAuthority().equals("ROLE_USER"))) {
            return "redirect:/tramite/form";
        }

        // En caso de que el usuario no tenga rol, se puede redirigir a otra página
        else {
            return "redirect:/error";
        }
    }
}
