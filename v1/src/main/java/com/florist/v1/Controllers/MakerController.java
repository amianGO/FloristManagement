package com.florist.v1.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.florist.v1.Entities.Maker;
import com.florist.v1.Services.MakerService;

@Controller
@RequestMapping("/Makers")
public class MakerController {
    @Autowired
    private MakerService makerService;
    
    public String saveMaker(Maker maker){
        makerService.save(maker);
        return "vacio"; //Aqui ira la plantilla a usar
    }
}
