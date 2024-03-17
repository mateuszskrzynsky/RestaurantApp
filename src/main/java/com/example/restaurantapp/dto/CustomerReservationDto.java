package com.example.restaurantapp.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CustomerReservationDto {

    private Long id;

    private LocalDateTime reservationTime;

    private Boolean isConfirm;

    private String customerEmail;

    private String customerName;



  }
