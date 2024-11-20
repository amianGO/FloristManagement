package com.florist.v1.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.florist.v1.Entities.Rol;
import com.florist.v1.Repositories.RolRepository;

@Service
public class RolService {
    @Autowired
    private RolRepository rolRepository;

    public void save(Rol rol) {
        rolRepository.save(rol);
    }

    public List<Rol> findRol () {
        return rolRepository.findAll();
    }

    public void deleteById (Long id) {
        rolRepository.deleteById(id);
    }





}
