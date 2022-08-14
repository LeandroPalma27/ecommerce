package com.leancoder.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    private String preToken = "tatitkm";

    @GetMapping("/login")
    public String Login(Model model) {
        model.addAttribute("title", "Iniciar sesion");
        return "login";
    }

}
