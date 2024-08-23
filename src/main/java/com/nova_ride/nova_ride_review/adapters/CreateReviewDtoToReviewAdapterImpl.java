package com.nova_ride.nova_ride_review.adapters;

import com.nova_ride.nova_ride_review.dtos.CreateReviewDto;

import com.nova_ride.nova_ride_review.repositories.BookingRepository;
import org.novaride.modelentity.models.Booking;
import org.novaride.modelentity.models.Review;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class CreateReviewDtoToReviewAdapterImpl implements CreateReviewDtoToReviewAdapter {
    //
    private BookingRepository bookingRepository;
    public CreateReviewDtoToReviewAdapterImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public Review convertDtoToReview(CreateReviewDto createReviewDto) {
//        Optional<Booking>booking=bookingRepository.findById(createReviewDto.getBookingId());
//        if(booking.isEmpty()){
//            return null;
//        }
//
//        return Review.builder()
//                .rating(createReviewDto.getRating())
//                .booking(booking.get())
//                .content(createReviewDto.getContent())
//                .build();

//functional adapter
        Optional<Booking>booking=bookingRepository.findById(createReviewDto.getBookingId());
        return booking.map(value -> Review.builder()
                .rating(createReviewDto.getRating())
                .booking(value)
                .content(createReviewDto.getContent())
                .build()).orElse(null);
    }
}
