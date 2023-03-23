package com.coherent.task.service;

import com.coherent.task.entity.Reservation;
import com.coherent.task.persistency.ReservationStorage;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
    public class ReservationService {

    @Autowired
    private ReservationStorage storage;
    @PostMapping("/reservation/create")
    public ResponseEntity<ReservationStorage> createReservation(@Valid @RequestBody Reservation reservation){


        return null;
    }

    @GetMapping("/reservations")
    public Set<Reservation> getReservations(){

        return storage.getReservations();
    }

    @PatchMapping("/reservation/update/{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable String id){

        return null;
    }
}
