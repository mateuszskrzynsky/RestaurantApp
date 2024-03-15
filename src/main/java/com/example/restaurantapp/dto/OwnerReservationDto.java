package com.example.restaurantapp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OwnerReservationDto {

    private String id;

    private String reservationTime;

    private Boolean isConfirm;

    private String customerName;

    private String customerEmail;



}
