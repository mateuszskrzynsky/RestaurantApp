package com.example.restaurantapp.controller;

import com.example.restaurantapp.dto.CustomerReservationDto;
import com.example.restaurantapp.dto.OwnerReservationDto;
import com.example.restaurantapp.model.Reservation;
import com.example.restaurantapp.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ownerReservation")
@RequiredArgsConstructor
public class OwnerReservationController {

    private final ReservationService reservationService;

    /**
     * Retrive a reservation by it's ID
     * @param id The ID of the reservation to retrive
     * @return The requested reservation if found, with HTTP status 200
     */
    @GetMapping("/getReservation/{id}")
    public ResponseEntity<CustomerReservationDto> getReservation(@PathVariable Long id){
        CustomerReservationDto reservation = reservationService.getById(id);
        return new ResponseEntity<>(reservation, HttpStatus.OK);
    }

    /**
     * Delete a reservation by its ID
     * @param id The ID of the reservation to delete
     * @return HTTP status 204 with no content it the deletion was successful
     */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<OwnerReservationDto> deleteReservation(@PathVariable Long id){
        Boolean deleted =  reservationService.deleteReservation(id);

        if (deleted){
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Creates a new reservation based on the provided data.
     * @param dto request data required to create the reservation
     * @return The created reservation with HTTP status 201
     */
    @PostMapping("/create")
    public ResponseEntity<CustomerReservationDto> createReservation(@RequestBody CustomerReservationDto dto){
        CustomerReservationDto newReservation = reservationService.createReservation(dto);
        return new ResponseEntity<>(newReservation, HttpStatus.CREATED);
    }

}
