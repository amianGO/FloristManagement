package com.florist.v1.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.florist.v1.Entities.Flower;
import com.florist.v1.Services.FlowerService;

@Controller
@RequestMapping("/Flowers")
public class FlowerController {
    @Autowired
    private FlowerService flowerService;
    
    @PostMapping("/save")
    public String saveFlower(Flower flower){
        flowerService.save(flower);
        return "flowerCreate"; //Aqui ira la plantilla HTMlL
    }
    
    @GetMapping("/List")
    public String listFlower(Model model){
        model.addAttribute("Flowers", flowerService.findFlowers());
        return "flowerList";
    }

}
