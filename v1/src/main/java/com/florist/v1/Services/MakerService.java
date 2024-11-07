package com.florist.v1.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.florist.v1.Entities.Maker;
import com.florist.v1.Repositories.MakerRepository;

@Service
public class MakerService {
    @Autowired
    private MakerRepository makerRepository;

    //Buscar Todo
    public List<Maker> findAllMakers(){
        return makerRepository.findAll();
    }

    //Buscar por Id
    public Optional<Maker> findMakerById(Long id){
        return makerRepository.findById(id);
    }

    //Guardar
    public Maker saveMaker(Maker maker){
        return makerRepository.save(maker);
    }

    //Actualizar
    public Maker updateMaker(Long id, Maker makerDetails){
        
        return makerRepository.findById(id).map(maker -> {
            maker.setName(makerDetails.getName());
            maker.setNit(makerDetails.getNit());
            return makerRepository.save(maker);
        }).orElseThrow(()-> new RuntimeException("Maker Not Found"));
    }

    //Borrar
    public void deleteMakerById(Long id){
        makerRepository.deleteById(id);
    }
}
