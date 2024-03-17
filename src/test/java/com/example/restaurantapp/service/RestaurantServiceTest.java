package com.example.restaurantapp.service;

import com.example.restaurantapp.model.KitchenType;
import com.example.restaurantapp.model.Restaurant;
import com.example.restaurantapp.repository.RestaurantRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RestaurantServiceTest {

    @Mock
    RestaurantRepository restaurantRepository;
    @InjectMocks
    RestaurantService restaurantService;

    @Test
    void findAllRestaurants() {
        // Given
        Restaurant restaurant1 = new Restaurant();
        restaurant1.setId(1L);
        restaurant1.setName("Florentina");
        restaurant1.setAddress("ul.Rajska 18, Warszawa");
        restaurant1.setKitchenType(KitchenType.ITALY);
        restaurant1.setOpeningHours("10-21");

        Restaurant restaurant2 = new Restaurant();
        restaurant2.setId(2L);
        restaurant2.setName("Blue Dragon");
        restaurant2.setAddress("ul.Wolna 18, Wrocław");
        restaurant2.setKitchenType(KitchenType.ASIAN);
        restaurant2.setOpeningHours("9-22");

        //WHEN
        when(restaurantService.findAllRestaurants()).thenReturn(Arrays.asList(restaurant1, restaurant2));
        List<Restaurant> result = restaurantService.findAllRestaurants();

        //THEN
        assertEquals(2, result.size());
        assertEquals("Florentina", result.get(0).getName());
        assertEquals("Blue Dragon", result.get(1).getName()); //TODO dopisać reszte wartości dla testu
    }

    @Test
    void findRestaurantById() {
        //GIVEN
        Restaurant restaurant = new Restaurant();
        restaurant.setId(1L);
        restaurant.setName("Florentina");

        //When
        when(restaurantRepository.findById(1L)).thenReturn(Optional.of(restaurant));

        Optional<Restaurant> result = restaurantService.findRestaurantById(1L);

        //THEN
        assertTrue(result.isPresent());
        assertEquals("Florentina", result.get().getName());
    }

    @Test
    void deleteRestaurant() {
        //Given
        Long restaurantId = 1L; // ID restauracji, którą chcemy usunąć

        //When
        restaurantService.deleteRestaurant(restaurantId);

        //Then
        verify(restaurantRepository, times(1)).deleteById(restaurantId);
    }

    @Test
    void createRestaurant() {
        // Given
        Restaurant restaurant = new Restaurant();
        restaurant.setName("Blue Dragon");

        //When
        when(restaurantRepository.save(any(Restaurant.class))).thenReturn(restaurant);

        Restaurant result = restaurantService.createRestaurant(restaurant);

        // THEN
        assertNotNull(result);
        assertEquals("Blue Dragon", result.getName());

    }
}