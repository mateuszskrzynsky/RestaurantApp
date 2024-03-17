package com.example.restaurantapp.service;

import com.example.restaurantapp.model.Review;
import com.example.restaurantapp.repository.ReviewRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ReviewServiceTest {

    @Mock
    ReviewRepository reviewRepository;
    @InjectMocks
    ReviewService reviewService;

    @Test
    void createReview() {
        //given
        Review review = new Review();
        review.setId(1L);
        review.setAuthor("Mateusz Skrzynski");
        review.setComment("Super lokal,polecam!");
        review.setRating(5);
        //when
        when(reviewRepository.save(any(Review.class))).thenReturn(review);
        Review savedReview = reviewService.createReview(review);

        // then
        assertNotNull(savedReview);
        assertEquals(1L, savedReview.getId());
        assertEquals("Mateusz Skrzynski", savedReview.getAuthor());
        assertEquals("Super lokal,polecam!", savedReview.getComment());
        assertEquals(5, savedReview.getRating());

        verify(reviewRepository, times(1)).save(any(Review.class));
    }

    @Test
    void findAllReview() {

        // Given
        Review review1 = new Review();
        review1.setId(1L);
        review1.setAuthor("Mateusz Skrzynski");
        review1.setComment("Super lokal,polecam!");
        review1.setRating(5);

        Review review2 = new Review();
        review2.setId(1L);
        review2.setAuthor("Monika Golebiowska");
        review2.setComment("Beznadziejny lokal,nie warto!");
        review2.setRating(1);

        List<Review> mockReviews = Arrays.asList(review1, review2);

        //When
        when(reviewRepository.findAll()).thenReturn(mockReviews);
        List<Review> reviews = reviewService.findAllReview();

        //Then
        assertNotNull(reviews);
        assertEquals(2, reviews.size()); // Sprawdzamy, czy otrzymaliśmy dokładnie 2 recenzje

        verify(reviewRepository, times(1)).findAll();
    }
}