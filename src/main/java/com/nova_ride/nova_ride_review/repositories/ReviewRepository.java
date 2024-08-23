package com.nova_ride.nova_ride_review.repositories;


import jakarta.persistence.Id;
import org.novaride.modelentity.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.Date;
import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    Integer countAllByRatingIsLessThanEqual(Double givenRating);

    List<Review> findAllByRatingIsLessThanEqual(Double givenRating);

    List<Review> findAllByCreatedAtBefore(Date date);

    @Query("select r from Booking b inner join Review r where b.id = :bookingId")
    Review findReviewByBookingId(Long bookingId);


}
//dto=>controllers=>service=>repositories=>entities mapped while extending jpa repo
