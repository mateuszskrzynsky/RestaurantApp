package com.example.restaurantapp.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CustomerReservationDto {

    private Long id;

    LocalDateTime reservationTime;

    Boolean isConfirm;

    String customerEmail;

    String customerName;



  }
