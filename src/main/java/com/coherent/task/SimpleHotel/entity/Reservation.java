package com.coherent.task.SimpleHotel.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
public class Reservation implements Serializable {

    private Integer id;

    private String clientFullName;

    private Integer roomNumber;

    private List<LocalDate> reservationDates;



}
