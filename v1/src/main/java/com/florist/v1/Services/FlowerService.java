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

    //Crear, Actualziar
    public void save(Flower flower){
        flowerRepository.save(flower);
    }

    //Leer
    public List<Flower> findFlowers(){
        return flowerRepository.findAll();
    }

    public Optional<Flower> findById(Long id){
        return flowerRepository.findById(id);
    }

    //Borrar
    public void deleteById(Long id){
        flowerRepository.deleteById(id);
    }
}
