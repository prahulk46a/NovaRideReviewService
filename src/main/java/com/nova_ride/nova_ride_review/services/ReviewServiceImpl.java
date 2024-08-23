package com.nova_ride.nova_ride_review.services;


import com.nova_ride.nova_ride_review.repositories.ReviewRepository;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.FetchNotFoundException;
import org.novaride.modelentity.models.Review;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {
    private ReviewRepository reviewRepository;

    ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> findAllReviews() {
        return reviewRepository.findAll();
    }

    @Override
    public Optional<Review> findReviewById(Long id) {
        Optional<Review> review;
        try {
            review = this.reviewRepository.findById(id);
            if (review.isEmpty()) {
                throw new EntityNotFoundException("Review with id " + id + " not found");
            }
        }catch (Exception e){
            e.printStackTrace();
            if(e.getClass() == EntityNotFoundException.class){
                throw new FetchNotFoundException("Review with id " + id + " not found", id);
            }
            throw new FetchNotFoundException("Unable to fetch, PLease try again later!", id);
        }
        return review;
    }

    @Override
    public boolean deleteReviewById(Long id) {
        try {
            reviewRepository.deleteById(id);
            return true;

        }catch (Exception e){
            return false;
        }
    }

    @Override
    public Review publishReview(Review review) {
        return this.reviewRepository.save(review);
    }

    @Override
    public Review updateReview(Long id, Review review) {
        Review newReview = this.reviewRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        if(review.getRating() != null){
            newReview.setRating(review.getRating());
        }
        if((review.getContent()!=null)){
            newReview.setContent(review.getContent());
        }
        return this.reviewRepository.save(newReview);
    }


}
