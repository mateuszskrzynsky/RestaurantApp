package com.example.restaurantapp.controller;

import com.example.restaurantapp.model.Reservation;
import com.example.restaurantapp.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservation")
@RequiredArgsConstructor
public class OwnerReservationController {

    private final ReservationService reservationService;


}
