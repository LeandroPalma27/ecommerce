package com.leancoder.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/items")
public class ItemsController {
    
    @GetMapping({"", "/"})
    public String Menu(Model model) {
        model.addAttribute("title", "Menu");
        return "items/home";
    }

}
