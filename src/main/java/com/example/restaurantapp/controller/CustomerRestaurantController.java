package com.example.restaurantapp.controller;

import com.example.restaurantapp.model.Restaurant;
import com.example.restaurantapp.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer_restaurant")
@RequiredArgsConstructor
public class CustomerRestaurantController {

    private final RestaurantService restaurantService;

    /**
     * Retrive a restaurant by it's ID
     * @param id The ID of the restaurant to retrive
     * @return The requested restaurant if found, with HTTP status 200, if not found HTTP status 404
     */

    @GetMapping("/getRestaurant/{id}")
    public ResponseEntity<Restaurant> getRestaurant(@PathVariable Long id){
        return restaurantService.findRestaurantById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());

    }

    /**
     * Retrive all added restaurants
     * @return The requested restaurants with HTTP status 200
     */
    @GetMapping("/all")
    public ResponseEntity<List<Restaurant>> getAllRestaurants() {
        List<Restaurant> restaurants = restaurantService.findAllRestaurants();
        return ResponseEntity.ok(restaurants);
    }

}
