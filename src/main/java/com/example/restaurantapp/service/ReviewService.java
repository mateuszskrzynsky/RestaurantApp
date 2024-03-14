package com.example.restaurantapp.service;

import com.example.restaurantapp.model.Review;
import com.example.restaurantapp.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;


    /**
     *
     * @param restaurantId
     * @return
     */
    public List<Review> findByRestaurant(Long restaurantId) {
        return reviewRepository.findByRestaurantId(restaurantId);
    }


    /**
     * Create a review for restaurant
     * @param review
     * @return
     */
    public Review saveReview(Review review) {
        return reviewRepository.save(review);
    }
}
