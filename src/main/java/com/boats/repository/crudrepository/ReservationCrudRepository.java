package com.boats.repository.crudrepository;

import com.boats.model.ReservationModel;
import org.springframework.data.repository.CrudRepository;

public interface ReservationCrudRepository extends CrudRepository<ReservationModel, Integer> {
}
