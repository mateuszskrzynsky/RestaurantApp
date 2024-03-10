package com.example.restaurantapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
@jakarta.persistence.Table(name = "TABLE")
public class Table {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int seats;
    private String locationDescription; // TODO <- jako możliwość wyboru stolika na podstawie układu restauracji


}
