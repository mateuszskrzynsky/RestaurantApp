package com.example.restaurantapp.repository;

import com.example.restaurantapp.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    /**
     *
     * @param restaurantId
     * @return
     */
    List<Review> findByRestaurantId(Long restaurantId);
}
