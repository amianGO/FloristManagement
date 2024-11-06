package com.florist.v1.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.florist.v1.Entities.Flower;
import com.florist.v1.Repositories.FlowerRepository;

@Service
public class FlowerService {
    @Autowired
    private FlowerRepository flowerRepository;

    //Metodo para buscar Todo
    public List<Flower> getAllFlowers(){
        return flowerRepository.findAll();
    }

    //Metodo para buscar por Id
    public Optional<Flower> getFlowerById(Long id){
        return flowerRepository.findById(id);
    }

    //Metodo para Guardar
    public Flower saveFlower(Flower flower){
        return flowerRepository.save(flower);
    }

    //Metodo para Borrar
    public void deleteFlowerById(Long id){
        flowerRepository.deleteById(id);
    }
}
