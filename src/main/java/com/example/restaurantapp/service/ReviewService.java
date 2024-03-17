package com.example.restaurantapp.service;

import com.example.restaurantapp.model.Restaurant;
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
     *Creates a new review entity with the given identifier
     * @param review The unique identifier for the new review
     * @return The newly created Review object
     */
    public Review createReview(Review review) {
        Review newReview = new Review();
        newReview = reviewRepository.save(newReview);
        return newReview;
    }

    /**
     *find an existing reviews from all added
     * @return corresponding to the requested review
     */
    public List<Review> findAllReview() {
        return reviewRepository.findAll();
    }

}
