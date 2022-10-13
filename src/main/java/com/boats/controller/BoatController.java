package com.boats.controller;

import com.boats.model.BoatModel;
import com.boats.service.BoatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController /*Estamos diciendo que esta clase es un controlador de tipo rest es decir que soporta peticiones HTTP*/
@RequestMapping("/api/Boat") /*127.0.0:8080/api/boat  para cuando lo ponga en el postman*/
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}) /*Para poder hacer las peticiones get, post, put y delete*/
public class BoatController {

    @Autowired
    private BoatService boatService;

    @GetMapping("/all") /*127.0.0.1/8080/api/boat/all*/
    public List<BoatModel> getAllBoats() {
        return boatService.getAllBoats();
    }

    @GetMapping("/{id}")
    public Optional<BoatModel> getBoat(@PathVariable ("id") Integer id) {
        return boatService.getBoat(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public BoatModel saveBoat(@RequestBody BoatModel boatModel) {
        return boatService.saveBoat(boatModel);
    }

    @DeleteMapping("/{id}")/*El PathVariable es para saber que voy a recibir por la dirección*/
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteBoat(@PathVariable ("id") Integer id) {
        return boatService.deleteBoat(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public BoatModel updateBoat(@RequestBody BoatModel boatModel) {
        return boatService.updateBoat(boatModel);
    }
}
