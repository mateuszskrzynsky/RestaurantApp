package com.example.restaurantapp.controller;

import com.example.restaurantapp.dto.CustomerReservationDto;
import com.example.restaurantapp.model.Restaurant;
import com.example.restaurantapp.model.Review;
import com.example.restaurantapp.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    /**
     * Retrive all added reviews
     * @return The requested reviews with HTTP status 200
     */
    @GetMapping("/get_all")
    public ResponseEntity<List<Review>> getAllReviews() {
        List<Review> reviews = reviewService.findAllReview();
        return ResponseEntity.ok(reviews);
    }

    /**
     * Creates a new review based on the provided data.
     * @param review request data required to create the review
     * @return The created review with HTTP status 201
     */
    @PostMapping("/create")
    public ResponseEntity<Review> createReview(@RequestBody Review review){
        Review newReview = reviewService.createReview(review);
        return new ResponseEntity<>(newReview, HttpStatus.CREATED);
    }



}
