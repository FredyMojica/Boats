package com.boats.repository;

import com.boats.model.BoatModel;
import com.boats.repository.crudrepository.BoatCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository /*Está diciendo que esto es un repositorio, es decir, que es parte de la capa de persistencia*/
public class BoatRepository {

    @Autowired /*Inyección de dependencias: es decir, spring levanta la instancia de una clase hasta de una interface y va a colocar su implementación*/
    private BoatCrudRepository boatCrudRepository;/*El autowired se encarga de inicializarla*/

    public List<BoatModel> getAllBoats() {
        return (List<BoatModel>) boatCrudRepository.findAll();
    }

    public Optional<BoatModel> getBoat(Integer id) {
        return boatCrudRepository.findById(id); /*buscar en la instancia del objeto, no en el objeto, con la variable id*/
    }/*El optional quita el problema de que si busco por el id espera que retorne algo pero sabe que puede ser null o un objeto de tipo boatmodel, controlar una excepción*/

    public BoatModel saveBoat(BoatModel boatModel) {
        return boatCrudRepository.save(boatModel);/*Acá se van a modificar tres parámetros, sin el id*/
    }

    public boolean deleteBoat(BoatModel boatModel) {
        boatCrudRepository.delete(boatModel);
        return true;
    }

    public BoatModel updateBoat(BoatModel boatModel) {
        return boatCrudRepository.save(boatModel);/*Acá se van a modificar los cuatro parámetros, incluido el id*/
    }
}
