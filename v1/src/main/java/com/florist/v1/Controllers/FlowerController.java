package com.florist.v1.Controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.florist.v1.Entities.Flower;
import com.florist.v1.Services.FlowerService;

@RestController
@RequestMapping("/Home/Flower")
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

    //Guardar 
    @PostMapping("/save") //Se ha eliminado el @RequestBody ya que es utilizado para recibir Json y aqui no los necesitamos
    public RedirectView saveFlower(@RequestParam Long makerId, Flower flower) {
        // Llamar al servicio pasando la flor y el makerId
        flowerService.saveFlower(flower, makerId);
        //Nos retorna a la pagina Principal
        return new RedirectView("/HomePage/flowerPage");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Flower> updateFlower(@PathVariable Long id, @RequestBody Flower flower, @RequestParam Long makerId){
        Flower updatedFlower = flowerService.updateFlower(id, flower, makerId);
        return new ResponseEntity<>(updatedFlower,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteFlower(@PathVariable Long id){
        flowerService.deleteFlowerById(id);
    }

}
