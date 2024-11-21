package com.florist.v1.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.florist.v1.Entities.Maker;
import com.florist.v1.Services.MakerService;

@Controller
@RequestMapping("/Makers")
public class MakerController {
    @Autowired
    private MakerService makerService;
    
    @PostMapping("/save")
    public String saveMaker(Maker maker){
        makerService.save(maker);
        return "makerCreate"; //Aqui ira la plantilla a usar
    }

    @GetMapping("/List")
    public String listMakers(Model model){
        model.addAttribute("makers", makerService.findAll());
        System.out.println(makerService.findAll());
        return "makerList";
    }

    @PostMapping("/edit")
    public String editMakers(@ModelAttribute Maker maker){
        System.out.println("Guardando Maker: " + maker);
        makerService.save(maker);
        return "redirect:/Makers/List";
    }

    @GetMapping("/edit/{id}")
    public String ShowEditForm(@PathVariable Long id, Model model){
        Maker maker = makerService.findById(id).
            orElseThrow(()-> new IllegalArgumentException("Proveedor no Encontrado con ID + " + id));
            model.addAttribute("maker", maker);
        return "makerEdit";
    }

    @PostMapping("/delete")
    public String deleteMaker(@RequestParam Long id){
        makerService.deleteById(id);
        return "redirect:/Makers/List";
    }
}
