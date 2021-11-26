package com.revature.cpsrest.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class TripBookingDto {

	private int id;
	private int seatsBooked;
	private TripDto trip;
	private PassengerDto passenger;
	private String status;

	private String passengerReviewOwner;
	private int passengerRatingOwner;
	private int ownerRatingPassenger;
	private String notificationStatus;
}
