package com.example.restaurantapp.service;

import com.example.restaurantapp.dto.CustomerReservationDto;
import com.example.restaurantapp.model.Reservation;
import com.example.restaurantapp.model.Restaurant;
import com.example.restaurantapp.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    /**
     * Find all Restaurants from db
     * @return The found Restaurant objects
     */

    public List<Restaurant> findAllRestaurants() {
        return restaurantRepository.findAll();
    }

    /**
     * Retrives a restaurant by its unique identifier
     * @param id The unique identifier of the restaurant to retrieve
     * @return The Restaurant corresponding to the requested restaurant
     */

    public Optional<Restaurant> findRestaurantById(Long id) {
        return restaurantRepository.findById(id);
    }

    /**
     * Delete a Restaurant by its unique identifier
     * @param id The unique identifier of the restaurant to delete
     */
    public void deleteRestaurant(Long id) {
        restaurantRepository.deleteById(id);
    }

    /**
     *Creates a new Restaurant
     * @param restaurant The unique identifier for the new restaurant
     * @return The newly created Restaurant object
     */
    public Restaurant createRestaurant(Restaurant restaurant) {
        Restaurant newRestaurant = new Restaurant();
        newRestaurant = restaurantRepository.save(newRestaurant);
        return newRestaurant;
    }


}
