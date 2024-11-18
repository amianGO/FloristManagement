package com.florist.v1.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.florist.v1.Entities.Maker;
import com.florist.v1.Repositories.MakerRepository;

@Service
public class MakerService {
    @Autowired
    private MakerRepository makerRepository;

    //Crear, Actualizar
    public void save(Maker maker){
        makerRepository.save(maker);
    }

    //Leer
    public List<Maker> findAll(){
        return makerRepository.findAll();
    }

    //Borrar
    public void deleteById(Long id){
        makerRepository.deleteById(id);
    }
}
