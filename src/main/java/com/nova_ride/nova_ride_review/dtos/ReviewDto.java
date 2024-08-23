package com.nova_ride.nova_ride_review.dtos;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ReviewDto {
    private Long id;
    private String content;
    private Double rating;
    private Long booking;
    private Date createdAt;
    private Date updatedAt;
}
