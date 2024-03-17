package com.example.restaurantapp.service;

import com.example.restaurantapp.dto.CustomerReservationDto;
import com.example.restaurantapp.model.Reservation;
import com.example.restaurantapp.repository.ReservationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ReservationServiceTest {

    @Mock
    private ReservationRepository reservationRepository;
    @InjectMocks
    private ReservationService reservationService;

    @Test
    void createReservation() {
        //GIVEN
        CustomerReservationDto dto = new CustomerReservationDto();
        dto.setId(1L);
        dto.setReservationTime(LocalDateTime.now());
        dto.setCustomerEmail("greg@gasnica.com");
        dto.setCustomerName("Grzegorz Braun");

        Reservation reservation = new Reservation();
        reservation.setId(dto.getId());
        reservation.setReservationTime(dto.getReservationTime());
        reservation.setCustomerEmail(dto.getCustomerEmail());
        reservation.setCustomerName(dto.getCustomerName());


        //WHEN
        when(reservationRepository.save(any(Reservation.class))).thenReturn(reservation);
        CustomerReservationDto resultDto = reservationService.createReservation(dto);

        // THEN
        assertNotNull(resultDto);
        assertEquals(dto.getId(), resultDto.getId());
        assertEquals(dto.getReservationTime(), resultDto.getReservationTime());
        assertEquals(dto.getCustomerEmail(), resultDto.getCustomerEmail());
        assertEquals(dto.getCustomerName(), resultDto.getCustomerName());
    }

    @Test
    void deleteReservation() {
        //GIVEM
        Long id = 1L;
        Reservation reservation = new Reservation();
        reservation.setId(id);
        //WHEN
        when(reservationRepository.findById(id)).thenReturn(Optional.of(reservation));
        Boolean result = reservationService.deleteReservation(id);
        //THEN
        assertTrue(result);
    }

    @Test
    void getById() {
        //GIVEN
        Long id = 1L;
        Reservation reservation = new Reservation();
        reservation.setId(id);
        reservation.setCustomerEmail("ale@kot.com");
        reservation.setCustomerName("Tomy Lee Jones");
        reservation.setReservationTime(LocalDateTime.now());
        //WHEN
        when(reservationRepository.findById(id)).thenReturn(Optional.of(reservation));
        CustomerReservationDto resultDto = reservationService.getById(id);
        //THEN
        assertNotNull(resultDto);
        assertEquals("Tomy Lee Jones", resultDto.getCustomerName());
        assertEquals("ale@kot.com", resultDto.getCustomerEmail());
    }
}