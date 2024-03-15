package com.example.restaurantapp.model;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;


@Data
@Entity
@Table(name = "RESTAURANT")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "OPENING_HOURS")
    private String openingHours;

//    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private Set<com.example.restaurantapp.model.Table> tables = new HashSet<>(); // import niezbędny!
//
//    @OneToOne
//    private Reservation reservation;
}
