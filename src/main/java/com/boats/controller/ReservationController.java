package com.boats.controller;

import com.boats.model.ReservationModel;
import com.boats.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all")
    public List<ReservationModel> getAllReservations(){
        return reservationService.getAllReservations();
    }

    @GetMapping("/{id}")
    public Optional<ReservationModel> getReservation(@PathVariable Integer id){
        return reservationService.getReservation(id);
    }

    @PostMapping("/save")
    public ReservationModel saveReservation(@RequestBody ReservationModel reservationModel){
        return reservationService.saveReservation(reservationModel);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteReservation(@PathVariable Integer id){
        reservationService.deleteReservation(id);
    }

    @PutMapping("/update")
    public ReservationModel updateReservation(@RequestBody ReservationModel reservationModel){
        return reservationService.updateReservation(reservationModel);
    }
}
