package com.florist.v1.Controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class IndexController {
    //Pagina Principal
    @GetMapping("/")
    public String showHomepage(){
        return "index";
    }
    @GetMapping("/HomePage/flowerPage")
    public String flowerPage(){
        return "flower";
    }
    @GetMapping("/HomePage/makerPage")
    public String makerPage(){
        return "maker";
    }
    @GetMapping("/HomePage/makerList")
    public String showMakerList(){
        return "makerList";
    }

}
