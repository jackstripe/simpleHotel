package com.coherent.task.service;

import com.coherent.task.entity.Reservation;
import com.coherent.task.persistency.ReservationStorage;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
    public class ReservationService {

    @PostMapping("/reservation/create")
    public ResponseEntity<ReservationStorage> createReservation(@Valid @RequestBody Reservation reservation){


        return null;
    }

    @GetMapping("/reservations")
    public List<Reservation> getReservations(){

        return null;
    }

    @PatchMapping("/reservation/update/{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable String id){

        return null;
    }
}
