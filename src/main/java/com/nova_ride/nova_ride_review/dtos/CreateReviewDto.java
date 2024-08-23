package com.nova_ride.nova_ride_review.dtos;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateReviewDto {
    //Whatever expected contents from user that we mention in this
    //we dont need review id as review id is managed automatically after creation of booking
    private String content;
    private double rating;

    private Long  bookingId;

}
