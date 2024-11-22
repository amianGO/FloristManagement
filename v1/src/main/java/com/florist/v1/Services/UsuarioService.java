package com.florist.v1.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.florist.v1.Entities.Usuario;
import com.florist.v1.Repositories.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario guardarUsuario(Usuario user){
       return usuarioRepository.save(user);
    }

    public List<Usuario> listarUsuarios(){
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> BuscarUsuarioPorID(Long id){
        return usuarioRepository.findById(id);
    }

    public void eliminarUsuario(long id){
        usuarioRepository.deleteById(id);
    }

}
