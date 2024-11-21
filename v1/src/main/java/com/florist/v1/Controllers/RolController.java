package com.florist.v1.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.florist.v1.Entities.Rol;
import com.florist.v1.Services.RolService;

@Controller
@RequestMapping("/roles")
public class RolController {

    @Autowired
    private RolService rolService;

    @GetMapping("/listar")
    public String listRol (Model model) {
        List<Rol> roles = rolService.findRol();
        model.addAttribute("roles", roles);
        return "roles";
    }

    @GetMapping("/crearRol")
    public String showForm (Model model) {
        model.addAttribute("roles", new Rol());
        return "rolCreateForm";
    }

    @PostMapping("/saveRol")
    public String saveRol (Rol rol) {
        rolService.save(rol);
        return "redirect:/roles/listar";
    }

    @GetMapping("/listar/{id}")
    public String deleteRol (@PathVariable Long id, Model model) {
        rolService.deleteById(id);
        return "redirect:/roles/listar"; 
    }

}
