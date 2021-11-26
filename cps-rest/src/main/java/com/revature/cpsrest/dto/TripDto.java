package com.revature.cpsrest.dto;

import java.util.Date;
import java.util.Set;

import com.revature.cpsrest.model.Owner;

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
public class TripDto {
	
	private int id;
	private String origin;
	private String destination;
	private String departureTime;
	private String carType;
	private double price;
	private Date date;
	private int numberOfPassengers;
	private int numberOfSeatsAvailable;
	private Owner owner;
	private String status;
	private Set<TripBookingDto> tripBookingList;
	private int rating;
}