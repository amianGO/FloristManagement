package com.florist.v1.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.florist.v1.Entities.Usuario;
import com.florist.v1.Services.UsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public String listUsers(Model model) {
        model.addAttribute("users", usuarioService.getAllUsers()); // Lista de usuarios
        return "users/list"; // Vista para mostrar usuarios
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("user", new Usuario()); // Usuario vacío para el formulario
        return "users/create"; // Vista para crear un usuario
    }

    @PostMapping
    public String createUser(@ModelAttribute("user") Usuario usuario) {
        usuarioService.saveUser(usuario); // Guarda el usuario
        return "redirect:/admin/users"; // Redirige a la lista de usuarios
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Usuario usuario = usuarioService.getUserById(id);
        model.addAttribute("user", usuario); // Usuario existente para editar
        return "users/edit"; // Vista para editar un usuario
    }

    @PostMapping("/{id}")
    public String updateUser(@PathVariable Long id, @ModelAttribute("user") Usuario usuario) {
        usuarioService.updateUser(id, usuario); // Actualiza el usuario
        return "redirect:/admin/users"; // Redirige a la lista de usuarios
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        usuarioService.deleteUser(id); // Elimina el usuario
        return "redirect:/admin/users"; // Redirige a la lista de usuarios
    }

}
