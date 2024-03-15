package com.example.restaurantapp.controller;

import com.example.restaurantapp.dto.CustomerReservationDto;
import com.example.restaurantapp.model.Reservation;
import com.example.restaurantapp.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customerReservation")
@RequiredArgsConstructor
public class CustomerReservationController {

    private final ReservationService reservationService;


    @PostMapping("/create")
    public ResponseEntity<CustomerReservationDto> createReservation(@RequestBody CustomerReservationDto dto){
       CustomerReservationDto newReservation = reservationService.createReservation(dto);
       return new ResponseEntity<>(newReservation, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteReservation(@PathVariable Long id){
        Boolean deleted =  reservationService.deleteReservation(id);

        if (deleted){
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getReservation/{id}")
    public ResponseEntity<CustomerReservationDto> getReservation(@PathVariable Long id){
         CustomerReservationDto newReservation = reservationService.getById(id);
        return new ResponseEntity<>(newReservation, HttpStatus.OK);
    }



}
