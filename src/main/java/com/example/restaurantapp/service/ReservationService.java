package com.example.restaurantapp.service;

import com.example.restaurantapp.dto.CustomerReservationDto;
import com.example.restaurantapp.model.Reservation;
import com.example.restaurantapp.repository.ReservationRepository;
import com.example.restaurantapp.utils.mapper.ReservationServiceMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;
//    private final ReservationServiceMapper reservationServiceMapper; TODO wyrzucić "convertToDto" i "convertToEntity" do MAPPERA!

    /**
     *Converts a Reservation entity to a CustomerReservationDto
     * @param reservation the Reservation entity to convert
     * @return The converted CustomerReservationDto
     */
    private CustomerReservationDto converToDto(Reservation reservation) {
        CustomerReservationDto customerReservationDto = new CustomerReservationDto();
        customerReservationDto.setReservationTime(reservation.getReservationTime());
        customerReservationDto.setCustomerName(reservation.getCustomerName());
        customerReservationDto.setId(reservation.getId());
        customerReservationDto.setCustomerEmail(reservation.getCustomerEmail());
        return customerReservationDto;
    }

    /**
     *Converts a CustomerReservationDto entity to a Reservation
     * @param dto the CustomerReservationDto entity to convert
     * @return The converted Reservation
     */
    private Reservation convertToEntity(CustomerReservationDto dto){
        Reservation reservation = new Reservation();
        reservation.setReservationTime(dto.getReservationTime());
        reservation.setCustomerEmail(dto.getCustomerEmail());
        reservation.setCustomerName(dto.getCustomerName());
        return reservation;
    }

    /**
     *Creates a configuration for Restaurant
     * @param dto The identifier od the dto fot which the reservation is created
     * @return The newly created Reservation object
     */
    public CustomerReservationDto createReservation(CustomerReservationDto dto) {
        Reservation reservation = this.convertToEntity(dto);
        reservation = reservationRepository.save(reservation);
        return converToDto(reservation);
    }

    /**
     *Deletes a Reservation by its unique identifier
     * @param id The unique identifier of the reservation to delete
     * @return delete exsisting reservation
     * @throws EntityNotFoundException if no reservation is found with provided id
     */
    public Boolean deleteReservation(Long id) {
        Optional<Reservation> reservation = reservationRepository.findById(id);
        if (reservation.isPresent()){
            reservationRepository.deleteById(id);
            return true;
        } else {
            throw new EntityNotFoundException("Reservation not found");
        }
    }

    /**
     * Retrives a reservation by its unique identifier and converts it to a DTO
     * @param id The unique identifier of the reservation to retrieve
     * @return CustomerReservationDto corresponding to the requested reservation
     */
    public CustomerReservationDto getById(Long id) {
        Optional<Reservation> reservation = reservationRepository.findById(id);
        CustomerReservationDto customerReservationDto = null;
        if(reservation.isPresent()){
            customerReservationDto = converToDto(reservation.get());
        }
        return customerReservationDto;
    }
}
