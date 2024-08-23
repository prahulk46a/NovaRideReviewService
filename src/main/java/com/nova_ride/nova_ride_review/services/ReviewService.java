package com.nova_ride.nova_ride_review.services;



import org.novaride.modelentity.models.Review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    public List<Review>findAllReviews();
    public Optional<Review> findReviewById(Long id);
    public boolean deleteReviewById(Long id);
    public Review publishReview(Review review);
    public Review updateReview(Long id, Review review);



}
