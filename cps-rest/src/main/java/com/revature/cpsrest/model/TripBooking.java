package com.revature.cpsrest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "trip_bookings")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class TripBooking {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "seats_booked")
	private int seatsBooked;

	@ManyToOne
	@JoinColumn(name = "trip_id")
	private Trip trip;

	@ManyToOne
	@JoinColumn(name = "passenger_id")
	private Passenger passenger;

	@Column(name = "status")
	private String status;
	
	@Column(name = "owner_rating_passenger")
	private int ownerRatingPassenger;
	
	@Column(name = "passenger_rating_owner")
	private int passengerRatingOwner;
	
	@Column(name = "passenger_review_owner")
	private String passengerReviewOwner;
	
	@Column(name = "notification_status")
	private String notificationStatus;

}
