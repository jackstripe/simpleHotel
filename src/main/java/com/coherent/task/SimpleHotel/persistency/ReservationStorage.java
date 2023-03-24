package com.coherent.task.SimpleHotel.persistency;

import com.coherent.task.SimpleHotel.entity.Reservation;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class ReservationStorage {

    public Set<Reservation> reservations = new HashSet<Reservation>();
    private String filePath = "myReservations.txt";

    private static final Logger LOGGER = LoggerFactory.getLogger(ReservationStorage.class.getName());

    @PreDestroy
    private void serialize(){

        LOGGER.info("Saves current reservations");
        try{
            File fileS = new ClassPathResource(filePath).getFile();
            FileOutputStream file = new FileOutputStream(fileS);
            ObjectOutputStream out = new ObjectOutputStream(file);
            for(Reservation reservation : reservations){
                //out.writeObject(reservations);
                out.writeObject(reservation);
            }
            out.close();
            file.close();
            LOGGER.info("Persist of reservation on file: {} end:" , fileS.getAbsolutePath() );

        }catch(IOException ioException){
            LOGGER.info("No reservations were saved");
        }
    }

    @PostConstruct
    private void deserialize()  {

        LOGGER.info("Start loading previous saved reservations");
        FileInputStream fi = null;
        ObjectInputStream oi = null;
        try {
            File f = new ClassPathResource(filePath).getFile();
            if (f.exists() && !f.isDirectory()) {

                fi = new FileInputStream(f);
                oi = new ObjectInputStream(fi);
                Reservation reservationLoad;
                for (;;) {
                    reservationLoad = (Reservation) oi.readObject();
                    reservations.add(reservationLoad);
                }
            }
        }catch (EOFException eofException) {
            LOGGER.info("Previous saved reservations are loaded");
        }catch(IOException ioException){
            LOGGER.info("No previous reservations were loaded");
        }catch(ClassNotFoundException classNotFoundException){

        }

    }



    public Reservation save(Reservation reservationCreated){

        reservations.add(reservationCreated);

        return reservationCreated;
    }

    public Set<Reservation> getReservations(){
        return this.reservations;
    }

    public Reservation updateReservations(Reservation reservationUpdated){


        List<Reservation> reservationOriginal = reservations.stream()
                .filter( original -> original.getId() == reservationUpdated.getId() ).collect(Collectors.toList());

        reservations.remove(reservationOriginal.get(0));

        reservations.add(reservationUpdated);

        return reservationUpdated;
    }

}
