package com.florist.v1.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.florist.v1.Entities.Flower;
import com.florist.v1.Services.FlowerService;

@Controller
@RequestMapping("/Flowers")
public class FlowerController {
    @Autowired
    private FlowerService flowerService;
    
    public String saveFlower(Flower flower){
        flowerService.save(flower);
        return "vacio"; //Aqui ira la plantilla HTMlL
    }
}
