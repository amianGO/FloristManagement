package com.florist.v1.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class indexController {
    
   /*  @GetMapping("/")
    public String showHomePage(){
        return "home";  //index.html es la pagina de inicio del administrador, home.html es la pagina de inicio del usuario
    } */

    @GetMapping("/index")
    public String showIndex(){
        return "index";  //index.html es la pagina de inicio del administrador
    }

    @GetMapping("/CreateFlower")
    public String createFlower(){
        return "flowerCreate";
    }

    @GetMapping("/CreateMaker")
    public String createMaker(){
        return "makerCreate";
    }

    @GetMapping("/ViewRoles")
    public String viewRoles(){
        return "roles";
    }

    @GetMapping("/loginView")
    public String createUser(){
        return "loginView";
    }
}
