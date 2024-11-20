package com.florist.v1.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class indexController {
    
    @GetMapping("/")
    public String showHomePage(){
        return "index";
    }

    @GetMapping("/CreateFlower")
    public String createFlower(){
        return "flowerCreate";
    }

    @GetMapping("/CreateMaker")
    public String createMaker(){
        return "makerCreate";
    }
}
