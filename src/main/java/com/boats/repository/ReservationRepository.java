package com.boats.repository;

import com.boats.model.ReservationModel;
import com.boats.repository.crudrepository.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    private List<ReservationModel> getAllReservations(){
        return (List<ReservationModel>) reservationCrudRepository.findAll();
    }

    private Optional<ReservationModel> getReservation(Integer id) {
        return reservationCrudRepository.findById(id);
    }

    public ReservationModel saveReservation(ReservationModel reservationModel){
        return  reservationCrudRepository.save(reservationModel);
    }

    public void deleteReservation(Integer id) {
        reservationCrudRepository.deleteById(id);
    }
}
