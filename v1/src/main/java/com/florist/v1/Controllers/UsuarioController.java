package com.florist.v1.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.florist.v1.Entities.Usuario;
import com.florist.v1.Services.UsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/crear")
    public String formCrearUsuario(Model model){
        model.addAttribute("usuario",new Usuario());
        return "crearUsuario";
    }

    @PostMapping("/crear")
    public String crearUsuario(@ModelAttribute Usuario usuario){
        usuarioService.guardarUsuario(usuario);
        return "redirect:/usuarios/lista";
    }

    @GetMapping("/lista")
    public String listarUsuarios(Model model){
        model.addAttribute("usuarios", usuarioService.listarUsuarios());
        return "listaUsuarios";
    }

    


}
