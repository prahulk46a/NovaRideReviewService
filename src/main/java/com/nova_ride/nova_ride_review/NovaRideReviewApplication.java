package com.nova_ride.nova_ride_review;

import jakarta.persistence.EntityListeners;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@EntityScan("org.novaride.modelentity.models")

public class NovaRideReviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(NovaRideReviewApplication.class, args);
	}

}
