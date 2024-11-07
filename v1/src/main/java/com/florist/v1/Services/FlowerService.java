package com.florist.v1.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.florist.v1.Entities.Flower;
import com.florist.v1.Entities.Maker;
import com.florist.v1.Repositories.FlowerRepository;
import com.florist.v1.Repositories.MakerRepository;

@Service
public class FlowerService {
    @Autowired
    private FlowerRepository flowerRepository;
    @Autowired
    private MakerRepository makerRepository;

    //Metodo para buscar Todo
    public List<Flower> getAllFlowers(){
        return flowerRepository.findAll();
    }

    //Metodo para buscar por Id
    public Optional<Flower> getFlowerById(Long id){
        return flowerRepository.findById(id);
    }

    //Metodo para Guardar
    public Flower saveFlower(Flower flower, Long makerId){
        Optional<Maker> maker = makerRepository.findById(makerId);
        if (maker.isPresent()) {
            flower.setMaker(maker.get());
            return flowerRepository.save(flower);
        } else {
            throw new RuntimeException("Maker  Not Found with ID: " + makerId);
        }
        
    }

    //Actualizar
    public Flower updateFlower(Long id, Flower flowerDetails, Long makerId){
        //Busca la flor Existente por ID
        Flower existingFlower = flowerRepository.findById(id)
                    .orElseThrow(()->new RuntimeException("Flower not Found with ID: " + id));
        //Busca el Maker y asignarlo a la flor
        Maker maker = makerRepository.findById(makerId)
                    .orElseThrow(()-> new RuntimeException("Maker not found with ID: "+ makerId));

        //Actualizar los detalles de la flor
        existingFlower.setColor(flowerDetails.getColor());
        existingFlower.setName(flowerDetails.getName());
        existingFlower.setSize(flowerDetails.getSize());
        existingFlower.setHealth(flowerDetails.getHealth());
        existingFlower.setMaker(maker);

        //Guardar y retornar la flor actualizada
        return flowerRepository.save(existingFlower);
    }

    //Metodo para Borrar
    public void deleteFlowerById(Long id){
        flowerRepository.deleteById(id);
    }

    
}
