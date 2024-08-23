package com.nova_ride.nova_ride_review.adapters;

import com.nova_ride.nova_ride_review.dtos.CreateReviewDto;
import org.novaride.modelentity.models.Review;


public interface CreateReviewDtoToReviewAdapter {
    public Review convertDtoToReview(CreateReviewDto createReviewDto);
}
