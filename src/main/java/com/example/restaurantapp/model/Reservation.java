package com.example.restaurantapp.model;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;
@Entity
@Data
@Table(name = "RESERVATION")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "CUSTOMER_NAME")
    private String customerName;
    @Column(name = "CUSTOMER_EMAIL")
    private String customerEmail;
    @Column(name = "RESERVATION_TIME")
    private LocalDateTime reservationTime;
    @Column(name = "CONFIRM")
    private boolean isConfirm;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "table_id", referencedColumnName = "id")
    private TableModel table;            //TODO - sprawdzić dlaczego IJ nie gryzie się z @ManyToOne <- odpowiedź - import


    @OneToOne
    private Restaurant restaurant;
}
