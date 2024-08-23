package com.nova_ride.nova_ride_review.repositories;


import org.novaride.modelentity.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    //this method only sufficient for booking and review but operations related to booking must be done in seprate service booking
//    @Query("Select r from Booking b inner join Review r on  b.review=r where b.id=:bookingId")
//    Review findByBookingId(Long bookingId);
}
