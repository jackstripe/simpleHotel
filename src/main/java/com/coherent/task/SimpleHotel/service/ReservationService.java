package com.coherent.task.SimpleHotel.service;

import com.coherent.task.SimpleHotel.entity.Reservation;
import com.coherent.task.SimpleHotel.persistency.ReservationStorage;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
public class ReservationService {

    @Autowired
    public ReservationStorage storage;

    public ReservationService(ReservationStorage storage){

        this.storage = storage;
    }

    @PostMapping("/reservation/create")
    public ResponseEntity<ReservationStorage> createReservation( @Valid @RequestBody Reservation reservation){

        storage.save(reservation);
        return ResponseEntity.created(null).build();
    }

    @GetMapping("/reservations")
    public Set<Reservation> getReservations(){

        return storage.getReservations();
    }

    @PatchMapping("/reservation/update/{id}")
    public ResponseEntity<Reservation> updateReservation(@Valid @RequestBody Reservation reservation){

        storage.updateReservations(reservation);
        return null;
    }
}
