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
import com.florist.v1.Repositories.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService {
    
    @Autowired
   private UsuarioRepository usuarioRepository;

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
