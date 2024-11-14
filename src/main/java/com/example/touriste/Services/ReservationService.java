package com.example.touriste.Services;

import com.example.touriste.Entities.Activite;
import com.example.touriste.Entities.Client;
import com.example.touriste.Entities.Reservation;
import com.example.touriste.Repositories.ActiviteRepository;
import com.example.touriste.Repositories.ClientRepository;
import com.example.touriste.Repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private ActiviteRepository activiteRepository;

    @Autowired
    private ClientRepository clientRepository;

    public List<Reservation> findAllReservations() {
        return reservationRepository.findAll();
    }

    public Reservation findReservationById(Long id) {
        return reservationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Réservation non trouvée avec l'ID : " + id));
    }

    public Reservation createReservation(Long clientId, Long activiteId, int nombreDePersonnes) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client non trouvé avec l'ID : " + clientId));
        Activite activite = activiteRepository.findById(activiteId)
                .orElseThrow(() -> new RuntimeException("Activité non trouvée avec l'ID : " + activiteId));

        Reservation reservation = new Reservation();
        reservation.setClient(client);
        reservation.setActivite(activite);
        reservation.setNombreDePersonnes(nombreDePersonnes);
        reservation.setDateReservation(LocalDateTime.now());
        reservation.setStatut("confirmée");

        return reservationRepository.save(reservation);
    }
}
