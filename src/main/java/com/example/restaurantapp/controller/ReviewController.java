package com.example.restaurantapp.controller;

import com.example.restaurantapp.model.Restaurant;
import com.example.restaurantapp.model.Review;
import com.example.restaurantapp.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    /**
     *
     * @param id
     * @return
     */
    @GetMapping
    public ResponseEntity<List<Review>> getByRestaurant(@PathVariable Long id) {
        List<Review> reviews = reviewService.findByRestaurant(id);
        return ResponseEntity.ok(reviews);
    }

}
