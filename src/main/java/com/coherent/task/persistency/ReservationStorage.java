package com.coherent.task.persistency;

import com.coherent.task.entity.Reservation;

import java.util.HashSet;
import java.util.Set;

public class ReservationStorage {

    private Set<Reservation> reservations =new HashSet<Reservation>();

    public Reservation save(Reservation reservationCreated){

        return null;
    }

    public Set<Reservation> getReservations(){
        return this.reservations;
    }

    public Reservation updateReservations(Reservation reservationUpdated){


        return null;
    }

}
