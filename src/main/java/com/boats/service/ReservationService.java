package com.boats.service;

import com.boats.model.ReservationModel;
import com.boats.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<ReservationModel> getAllReservations(){
        return reservationRepository.getAllReservations();
    }

    public Optional<ReservationModel> getReservation(Integer id){
        return reservationRepository.getReservation(id);
    }

    public ReservationModel saveReservation(ReservationModel reservationModel){
        if (reservationModel.getId()==null){
            return reservationRepository.saveReservation(reservationModel);
        }else {
            Optional<ReservationModel> optionalReservationModel=reservationRepository.getReservation(reservationModel.getId());
            if (optionalReservationModel.isEmpty()){
                return  reservationRepository.saveReservation(reservationModel);
            }else {
                return reservationModel;
            }
        }
    }

    public ReservationModel updateReservation(ReservationModel reservationModel){
        if (reservationModel.getId()!=null){
            Optional<ReservationModel> optionalReservationModel=reservationRepository.getReservation(reservationModel.getId());
            if (!optionalReservationModel.isEmpty()){
                if (reservationModel.getStartDate()!=null){
                    optionalReservationModel.get().setStartDate(reservationModel.getStartDate());
                }
                if (reservationModel.getDevolutionDate()!=null){
                    optionalReservationModel.get().setDevolutionDate(reservationModel.getDevolutionDate());
                }
                reservationRepository.saveReservation(optionalReservationModel.get());
                return  optionalReservationModel.get();
            }else {
                return reservationModel;
            }
        }else {
            return  reservationModel;
        }
    }

    public boolean deleteReservation(Integer id){
        Boolean aBoolean=getReservation(id).map(reservationModel -> {
            reservationRepository.deleteReservation(reservationModel);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
