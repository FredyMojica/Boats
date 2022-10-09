package com.boats.repository.crudrepository;

import com.boats.model.BoatModel;
import org.springframework.data.repository.CrudRepository;

public interface BoatCrudRepository extends CrudRepository <BoatModel, Integer> {
}
