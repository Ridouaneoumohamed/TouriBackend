package com.example.touriste.Controllers;


import com.example.touriste.Entities.Reservation;
import com.example.touriste.Services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;


    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservationService.findAllReservations();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable Long id) {
        Reservation reservation = reservationService.findReservationById(id);
        return ResponseEntity.ok(reservation);
    }

    @PostMapping
    public ResponseEntity<Reservation> createReservation(@RequestParam Long clientId,
                                                         @RequestParam Long activiteId,
                                                         @RequestParam int nombreDePersonnes) {
        Reservation newReservation = reservationService.createReservation(clientId, activiteId, nombreDePersonnes);
        return ResponseEntity.status(HttpStatus.CREATED).body(newReservation);
    }
}
