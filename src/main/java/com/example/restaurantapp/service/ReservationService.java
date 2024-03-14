package com.example.restaurantapp.service;

import com.example.restaurantapp.model.Reservation;
import com.example.restaurantapp.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;


    /**
     *
     * @return
     */
    public List<Reservation> findAllReservations() {
        return reservationRepository.findAll();
    }

    /**
     *
     * @param id
     * @return
     */
    public Optional<Reservation> findReservationById(Long id) {
        return reservationRepository.findById(id);
    }

    /**
     *
     * @param reservation
     * @return
     */
    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    /**
     *
     * @param id
     */
    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }


}
