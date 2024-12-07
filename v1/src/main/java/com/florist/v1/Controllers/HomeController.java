package com.florist.v1.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.florist.v1.Services.FlowerService;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private FlowerService flowerService;

    // Controlador para la página de inicio
    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("inventory", flowerService.findFlowers());
        return "home"; 
    }
}