package com.florist.v1.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @PostMapping("/edit")
    public String editFlower(@ModelAttribute Flower flower){
        flowerService.save(flower);
        return "redirect:/Flowers/List";
    }

    @PostMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model){
        Flower flower = flowerService.findById(id).
            orElseThrow(()-> new IllegalArgumentException("Flor no encontrada con ID:" + id));
            model.addAttribute("flower", flower);
        return "flowerEdit";
    }
    
    @PostMapping("/delete")
    public String deleteFlower(@RequestParam Long id){
        flowerService.deleteById(id);
        return "redirect:/Flowers/List";
    }

}
