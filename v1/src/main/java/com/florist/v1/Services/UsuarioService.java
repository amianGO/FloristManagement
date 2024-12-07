package com.florist.v1.Services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.florist.v1.Entities.Usuario;
import com.florist.v1.Repositories.RolRepository;
import com.florist.v1.Repositories.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService {
    
    @Autowired
   private UsuarioRepository usuarioRepository;

   @Autowired
    private RolRepository roleRepository;  // Si estás gestionando roles como entidades

    // Obtener todos los usuarios
    public List<Usuario> getAllUsers() {
        return usuarioRepository.findAll();
    }

    // Crear un nuevo usuario
    public Usuario saveUser(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Obtener un usuario por ID
    public Usuario getUserById(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));
    }

    // Actualizar un usuario
    public Usuario updateUser(Long id, Usuario updatedUser) {
        Usuario existingUser = usuarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));
        
        existingUser.setUsername(updatedUser.getUsername());
        existingUser.setPassword(updatedUser.getPassword());  // Asegúrate de encriptar la contraseña
        existingUser.setRoles(updatedUser.getRoles());  // Asignación de roles

        return usuarioRepository.save(existingUser);
    }

    // Eliminar un usuario por ID
    public void deleteUser(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));
        usuarioRepository.delete(usuario);
    }

     @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Busca al usuario por su nombre de usuario
        Usuario usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));

        // Convierte los roles del usuario a SimpleGrantedAuthority
        List<GrantedAuthority> authorities = usuario.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getName()))
                .collect(Collectors.toList());

        // Retorna un objeto UserDetails con la información del usuario
        return new org.springframework.security.core.userdetails.User(
                usuario.getUsername(),
                usuario.getPassword(),
                authorities
        );
    }

   


}
