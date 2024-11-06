package com.florist.v1.Controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.florist.v1.Entities.Flower;
import com.florist.v1.Services.FlowerService;

@RestController
@RequestMapping("/Home")
public class FlowerController {

    @Autowired
    private FlowerService flowerService;


    @GetMapping()
    public List<Flower> getAllFlowers(){
        return flowerService.getAllFlowers();
    }

    @GetMapping("/find/{id}")
    public Optional<Flower> getFlowerById(@PathVariable Long id){
        return flowerService.getFlowerById(id);
    }

    @PostMapping("/save")
    public Flower saveFlower(@RequestBody Flower flower){
        return flowerService.saveFlower(flower);
    }

    @PutMapping("/update/{id}")
    public Flower updateFlower(@PathVariable Long id, @RequestBody Flower flower){
        flower.setId(id);
        return flowerService.saveFlower(flower);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFlower(@PathVariable Long id){
        flowerService.deleteFlowerById(id);
    }

}
