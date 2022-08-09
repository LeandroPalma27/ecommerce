package com.leancoder.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    
    @GetMapping({"", "/"})
    public String Home(Model model) {
        model.addAttribute("title", "Ecommerce");
        return "home";
    }

}
