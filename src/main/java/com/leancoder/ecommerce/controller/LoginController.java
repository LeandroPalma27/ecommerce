package com.leancoder.ecommerce.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    private String preToken = "tatitkm";

    @GetMapping("/login")
    public String Login(@RequestParam(value="error", required = false) String error, Principal principal, RedirectAttributes flash, Model model) {
        model.addAttribute("title", "Iniciar sesion");
        if (principal != null) {
            flash.addFlashAttribute("info", "Ya se ha iniciado sesion.");
            return "redirect:/";
        }
        if (error != null) {
            model.addAttribute("errorLogin", "No se encontro una cuenta con los credenciales ingresados.");
        }
        return "login";
    }

}
