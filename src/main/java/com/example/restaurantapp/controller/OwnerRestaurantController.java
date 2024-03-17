package com.example.restaurantapp.controller;

import com.example.restaurantapp.model.Restaurant;
import com.example.restaurantapp.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/owner_restaurant")
@RequiredArgsConstructor
public class OwnerRestaurantController {

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



    /**
     * Delete a restaurant by its ID
     * @param id The ID of the restaurant to delete
     * @return HTTP status 204 with no content it the deletion was successful
     */
    @DeleteMapping("/deleteBy{id}")
    public ResponseEntity<Void> deleteRestaurant(@PathVariable Long id) {
        restaurantService.deleteRestaurant(id);
        return ResponseEntity.ok().build();
    }

    /**
     * Creates a new restaurant based on the provided data.
     * @param restaurant request data required to create the restaurant
     * @return The created restaurant with HTTP status 201
     */
    @PostMapping("/create")
    public ResponseEntity<Restaurant> createRestaurant(@RequestBody Restaurant restaurant){
        Restaurant newRestaurant = restaurantService.createRestaurant(restaurant);
        return new ResponseEntity<>(newRestaurant, HttpStatus.CREATED);
    }
}
