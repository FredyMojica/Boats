package com.boats.repository;

import com.boats.model.ClientModel;
import com.boats.model.ClientReport;
import com.boats.model.ReservationModel;
import com.boats.repository.crudrepository.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<ReservationModel> getAllReservations(){
        return (List<ReservationModel>) reservationCrudRepository.findAll();
    }

    public Optional<ReservationModel> getReservation(Integer id) {
        return reservationCrudRepository.findById(id);
    }

    public ReservationModel saveReservation(ReservationModel reservationModel){
        return  reservationCrudRepository.save(reservationModel);
    }

    public boolean deleteReservation(ReservationModel reservationModel) {
        reservationCrudRepository.delete(reservationModel);
        return true;
    }

    public List<ReservationModel> getReservationByStatus(String status){
        return reservationCrudRepository.findAllByStatus(status);
    }

    public List<ReservationModel> getReservationPeriod(Date dateOne, Date dateTwo){
        return reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(dateOne, dateTwo);
    }

    public List<ClientReport> getTopClients(){
        List<ClientReport> response = new ArrayList<>();
        List<Object[]> report = reservationCrudRepository.countTotalReservationByClient();
        for (int i=0; i< report.size(); i++){
            response.add(new ClientReport((Long)report.get(i)[1], (ClientModel) report.get(i)[0]));
        }
        return response;
    }
}
