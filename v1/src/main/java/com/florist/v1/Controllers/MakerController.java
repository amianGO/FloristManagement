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
import org.springframework.web.bind.annotation.RestController;

import com.florist.v1.Entities.Flower;
import com.florist.v1.Entities.Maker;
import com.florist.v1.Services.MakerService;

@RestController
@RequestMapping("/Home/Maker")
public class MakerController {
    
    @Autowired
    private MakerService makerService;

    //Crear Nuevo Maker
    @PostMapping("/save")
    public ResponseEntity<Maker> createMaker(@RequestBody Maker maker){
        //llama la capa de servicio para guardar el maker en la base de datos
        Maker savedMaker = makerService.saveMaker(maker);
        //Devolver una respuesta HTTP CREATED con el objeto Maker guardado
        return new ResponseEntity<>(savedMaker,HttpStatus.CREATED);
    }

    //Obtener todo
    @GetMapping("/findAll")
    public ResponseEntity<List<Maker>> getAllMakers(){
        //Llamar la capa de servicio para obtener la lista completa de makers
        List<Maker> makers = makerService.findAllMakers();
        //Devolver una respuesta HTTP con los objetos maker
        return new ResponseEntity<>(makers,HttpStatus.OK);
    }

    //Obtener por ID
    @GetMapping("/find/{id}")
    public ResponseEntity<Maker> getMakerById(@PathVariable long id){
        //Busca el Maker por ID usando la capa de Servicio
        Optional<Maker> makerOptional = makerService.findMakerById(id);
        //Si el maker existe, devolver una respuesta http OK con el objeto Maker
        //Si no, devuelve devuelve una respuesta HTTP not Found
        return makerOptional.map(value -> new ResponseEntity<>(value,HttpStatus.OK))
                            .orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    //Actualizar 
    @PutMapping("/edit/{id}")
    public ResponseEntity<Maker> updateMaker(@PathVariable long id, @RequestBody Maker maker){
        //Llama la capa de servicio para actualizzar el maker con el Id que ingresemos
        Maker updatedMaker = makerService.updateMaker(id, maker);
        //Devuelve una respuesta Http Ok Y el objeto Actualizado
        return new ResponseEntity<>(updatedMaker,HttpStatus.OK);
    }

    //Borrar
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteMakerById(@PathVariable long id){
        //Llama la capa de servicio paara borrar el maker con el Id que ingresamos
        makerService.deleteMakerById(id);
        //Devuelve una respuesta HTTP Sin contenido
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //Obtener las flores de un Maker
    @GetMapping("/{id}/flowers")
    public ResponseEntity<List<Flower>> getFlowersByMakerId(@PathVariable long id){
        //Busca el maker por Id mediante la capa de servicio
        Optional<Maker> maker = makerService.findMakerById(id);
        //Si esta, devuelve los objetos "flower" asignados y un HTTP Ok
        //Si no, devuelve un HTTP sin contenido
        return maker.map(value -> new ResponseEntity<>(value.getFlowerList(),HttpStatus.OK))
                    .orElseGet(()-> new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }
    



}
