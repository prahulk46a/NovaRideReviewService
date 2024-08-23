package com.nova_ride.nova_ride_review.controllers;

import com.nova_ride.nova_ride_review.adapters.CreateReviewDtoToReviewAdapter;
import com.nova_ride.nova_ride_review.dtos.CreateReviewDto;
import com.nova_ride.nova_ride_review.dtos.ReviewDto;
import com.nova_ride.nova_ride_review.services.ReviewService;
import org.novaride.modelentity.models.Review;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/reviews")
public class ReviewController {
    private ReviewService reviewService;
    private CreateReviewDtoToReviewAdapter createReviewDtoToReviewAdapter;

    public ReviewController(ReviewService reviewService, CreateReviewDtoToReviewAdapter createReviewDtoToReviewAdapter) {
        this.reviewService = reviewService;
        this.createReviewDtoToReviewAdapter = createReviewDtoToReviewAdapter;
    }


    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews(){
        List<Review> reviews = this.reviewService.findAllReviews();
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }


    //we pass createReviewDtoObj but response entity
    @PostMapping
    public ResponseEntity<?> publishReview(@Validated @RequestBody CreateReviewDto reviewDto){
        //this publish review method expects review obj as parameter but we are passing reviewDto obj so we use adapters(logic which converts dto to review)
        Review incomingReview=this.createReviewDtoToReviewAdapter.convertDtoToReview(reviewDto);
        if(incomingReview==null){
            return new ResponseEntity<>("Invalid inputs",HttpStatus.BAD_REQUEST);
        }
        Review result = this.reviewService.publishReview(incomingReview);
        ReviewDto response = ReviewDto.builder()
                .id(result.getId())
                .content(result.getContent())
                .booking(result.getBooking().getId())
                .rating(result.getRating())
                .createdAt(result.getCreatedAt())
                .updatedAt(result.getUpdatedAt())
                .build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<?> findReviewById(@PathVariable("reviewId") Long reviewId) {
        try {
            Optional<Review> review = this.reviewService.findReviewById(reviewId);
            return new ResponseEntity<>(review, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{reviewId}")
    public ResponseEntity<?> deleteReviewById(@PathVariable Long reviewId) {
        try {
            boolean isDeleted = this.reviewService.deleteReviewById(reviewId);
            if(!isDeleted) return new ResponseEntity<>("Unable to delete Review", HttpStatus.INTERNAL_SERVER_ERROR);
            return new ResponseEntity<>("Review deleted successfully", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PutMapping("/{reviewId}")
    public ResponseEntity<?> updateReview(@PathVariable Long reviewId, @RequestBody Review request){
        try {
            Review review = this.reviewService.updateReview(reviewId, request);
            return new ResponseEntity<>(review, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
