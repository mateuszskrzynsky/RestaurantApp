package com.example.restaurantapp.service;

import com.example.restaurantapp.dto.CustomerReservationDto;
import com.example.restaurantapp.model.Reservation;
import com.example.restaurantapp.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;


    public CustomerReservationDto createReservation(CustomerReservationDto dto) {
        Reservation reservation = this.convertToEntity(dto);
        reservation = reservationRepository.save(reservation);
        return converToDto(reservation);
    }

    private CustomerReservationDto converToDto(Reservation reservation) {
        CustomerReservationDto customerReservationDto = new CustomerReservationDto();
        customerReservationDto.setReservationTime(reservation.getReservationTime());
        customerReservationDto.setCustomerName(reservation.getCustomerName());
        customerReservationDto.setId(reservation.getId());
        customerReservationDto.setCustomerEmail(reservation.getCustomerEmail());
        return customerReservationDto;
    }


    private Reservation convertToEntity(CustomerReservationDto dto){
        Reservation reservation = new Reservation();
        reservation.setReservationTime(dto.getReservationTime());
        reservation.setCustomerEmail(dto.getCustomerEmail());
        reservation.setCustomerName(dto.getCustomerName());
        return reservation;
    }

    public Boolean deleteReservation(Long id) {
        Optional<Reservation> reservation = reservationRepository.findById(id);
        if (reservation.isPresent()){
            reservationRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public CustomerReservationDto getById(Long id) {
        Optional<Reservation> reservation = reservationRepository.findById(id);
        CustomerReservationDto customerReservationDto = null;
        if(reservation.isPresent()){
            customerReservationDto = converToDto(reservation.get());
        }
        return customerReservationDto;
    }
}
