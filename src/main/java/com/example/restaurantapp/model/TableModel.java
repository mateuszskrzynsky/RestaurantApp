package com.example.restaurantapp.model;

import jakarta.persistence.*;

import lombok.Data;

@Data
@Entity
public class TableModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int seats;

    private String locationDescription; // TODO <- jako możliwość wyboru stolika na podstawie układu restauracji

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "restaurant_id")
//    private Restaurant restaurant;
//
//    @OneToMany(mappedBy = "table", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private Set<Reservation> reservations;
}
